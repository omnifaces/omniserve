/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.validator;

import javax.el.ValueExpression;
import javax.inject.Inject;
import org.omnifaces.serve.component.EditableValueHolder;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.validator.ValidatorFactory;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:validateLength.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/validator", localName = "validateLength")
public class ValidateLengthProcessor extends ServeAttachedObjectProcessor {

    // TODO support for attribute.
    /**
     * Stores the validator factory.
     */
    @Inject
    private ValidatorFactory validatorFactory;

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        EditableValueHolder input = getClosestParent(parent, EditableValueHolder.class);
        LengthValidator validator = (LengthValidator) validatorFactory.createValidator(
                "org.omnifaces.serve.ext.validator.LengthValidator");
        if (attributes.containsKey("maximum")) {
            Integer maximum = (Integer) context.evaluate(attributes.get("maximum").getValue(), Integer.class);
            validator.setMaximum(maximum);
        }
        if (attributes.containsKey("minimum")) {
            Integer maximum = (Integer) context.evaluate(attributes.get("minimum").getValue(), Integer.class);
            validator.setMinimum(maximum);
        }
        if (attributes.containsKey("disabled")) {
            String attributeString = attributes.get("disabled").getValue();
            ValueExpression ve = context.getExpressionFactory().createValueExpression(
                    context.getContext().getELContext(), attributeString, boolean.class);
            validator.setValueExpression("disabled", ve);
        }
        input.addValidator(validator);
    }
}
