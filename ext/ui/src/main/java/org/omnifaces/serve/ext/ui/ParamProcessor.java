/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import javax.el.ValueExpression;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for ui:param.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/ui", localName = "param")
public class ParamProcessor extends ServeAttachedObjectProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        String name = (String) context.evaluate(attributes.get("name").getValue(), String.class);
        String value = attributes.get("value").getValue();
        ValueExpression ve = context.createValueExpression(value, Object.class);
        context.getVariableMapper().setVariable(name, ve);
    }
}
