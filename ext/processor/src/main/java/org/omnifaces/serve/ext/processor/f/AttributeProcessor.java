/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.f;

import javax.el.ValueExpression;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:attribute.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/f", localName = "attribute")
public class AttributeProcessor extends ServeAttachedObjectProcessor {

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
        if (!parent.getAttributes().containsKey(name)) {
            String valueString = attributes.get("value").getValue();
            ValueExpression ve = context.createValueExpression(valueString, Object.class);
            if (ve.isLiteralText()) {
                parent.getAttributes().put(name, valueString);
            } else {
                parent.setValueExpression(name, ve);
            }
        }
    }
}
