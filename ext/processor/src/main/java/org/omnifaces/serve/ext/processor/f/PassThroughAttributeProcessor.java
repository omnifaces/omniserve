/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.f;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:passThroughAttribute.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/f", localName = "passThroughAttribute")
public class PassThroughAttributeProcessor extends ServeAttachedObjectProcessor {

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
        Object value = context.evaluate(attributes.get("value").getValue(), Object.class);
        parent.getPassThroughAttributes().put(name, value);
    }
}
