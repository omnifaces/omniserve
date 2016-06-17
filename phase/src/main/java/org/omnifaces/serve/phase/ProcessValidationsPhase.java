/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

import java.util.List;
import javax.el.ValueExpression;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import org.omnifaces.serve.component.EditableValueHolder;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.converter.Converter;
import org.omnifaces.serve.converter.ConverterFactory;
import org.omnifaces.serve.event.ValueChangeEvent;
import org.omnifaces.serve.event.ValueChangeListener;
import org.omnifaces.serve.validator.Validator;
import org.omnifaces.serve.validator.ValidatorException;
import org.omnifaces.serve.vist.DefaultVisitContext;
import org.omnifaces.serve.vist.DefaultVisitTree;
import org.omnifaces.serve.vist.VisitCallback;
import org.omnifaces.serve.vist.VisitContext;
import org.omnifaces.serve.vist.VisitResult;

/**
 * The "PROCESS_VALIDATIONS" phase.
 */
@ApplicationScoped
@Default
@ServePhaseId("PROCESS_VALIDATIONS")
public class ProcessValidationsPhase extends BasePhase {

    /**
     * Stores the converter factory.
     */
    @Inject
    private ConverterFactory converterFactory;

    /**
     * Execute the phase.
     *
     * @param context the context.
     */
    @Override
    public void execute(PhaseContext context) {
        context.setCurrentPhaseId(getId());
        if (!shouldSkip(context)) {
            UIViewRoot viewRoot = context.getViewRoot();
            DefaultVisitTree visitTree = new DefaultVisitTree();
            DefaultVisitContext visitContext = new DefaultVisitContext();
            visitTree.visitTree(visitContext, viewRoot,
                    (VisitCallback<VisitContext, UIComponent>) (VisitContext visitContextParam,
                            UIComponent target) -> {
                        VisitResult result = VisitResult.ACCEPT;

                        if (target instanceof EditableValueHolder) {
                            EditableValueHolder evh = (EditableValueHolder) target;
                            Object submittedValue = evh.getSubmittedValue();
                            if (submittedValue != null) {
                                Object convertedValue = getConvertedValue(context, evh);
                                Object oldValue = evh.getValue();

                                try {
                                    List<Validator> validators = evh.getValidators();
                                    validators.stream().forEach((validator) -> {
                                        validator.validate(convertedValue);
                                    });

                                    evh.setSubmittedValue(null);
                                    evh.setLocalValue(convertedValue);

                                    if ((oldValue == null && convertedValue != null)
                                    || (convertedValue == null && oldValue != null)
                                    || (convertedValue != null && !convertedValue.equals(oldValue))) {
                                        List<ValueChangeListener> valueChangeListeners = evh.getValueChangeListeners();
                                        for (ValueChangeListener valueChangeListener : valueChangeListeners) {
                                            ValueChangeEvent event = new ValueChangeEvent(
                                                    evh, oldValue, convertedValue);
                                            valueChangeListener.processValueChange(event);
                                        }
                                    }
                                } catch (ValidatorException ve) {
                                    String id = (String) target.getValueExpression("id").
                                    getValue(context.getELContext());
                                    PhaseMessage message = new PhaseMessage(ve.getMessage());
                                    context.addMessage(id, message);
                                    context.renderResponse();
                                    result = VisitResult.COMPLETE;
                                }
                            }
                        }

                        return result;
                    });
        }
    }

    /**
     * Get the converted value.
     *
     * @param context the context.
     * @param evh the editable value holder.
     * @return the converted value.
     */
    private Object getConvertedValue(Context context, EditableValueHolder evh) {
        Object result = null;
        Converter converter = evh.getConverter();
        if (converter == null) {
            UIComponent component = (UIComponent) evh;
            ValueExpression ve = (ValueExpression) component.getValueExpression("value");
            if (ve != null) {
                Class<?> expectedType = ve.getType(context.getELContext());
                if (!expectedType.equals(Object.class) && !expectedType.equals(String.class)) {
                    converter = converterFactory.createConverter(expectedType);
                }
            }
        }
        if (converter == null && !evh.getSubmittedValue().equals("")) {
            result = evh.getSubmittedValue();
        } else if (converter != null) {
            result = converter.getAsObject((String) evh.getSubmittedValue());
        }
        return result;
    }

    /**
     * Get the phase id.
     *
     * @return the phase id.
     */
    @Override
    public PhaseId getId() {
        return PhaseId.PROCESS_VALIDATIONS;
    }
}
