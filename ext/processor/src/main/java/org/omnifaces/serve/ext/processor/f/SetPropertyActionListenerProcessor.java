/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.f;

import javax.el.ValueExpression;
import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.event.ActionSource;
import org.omnifaces.serve.event.ServeActionListenerLiteral;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:setPropertyActionListener.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/f", localName = "setPropertyActionListener")
public class SetPropertyActionListenerProcessor extends ServeAttachedObjectProcessor {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    // TODO support for attribute.
    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        ActionSource actionSource = getClosestParent(parent, ActionSource.class);

        String valueString = attributes.get("value").getValue();
        ValueExpression valueVE = context.getExpressionFactory().createValueExpression(
                context.getContext().getELContext(), valueString, Object.class);

        String targetString = attributes.get("target").getValue();
        ValueExpression targetVE = context.getExpressionFactory().createValueExpression(
                context.getContext().getELContext(), targetString, Object.class);

        SetPropertyActionListener actionListener = cdiManager.getInstance(SetPropertyActionListener.class,
                new ServeActionListenerLiteral("SET_PROPERTY_ACTION"));
        actionListener.setValue(valueVE);
        actionListener.setTarget(targetVE);
        actionSource.addActionListener(actionListener);
    }
}
