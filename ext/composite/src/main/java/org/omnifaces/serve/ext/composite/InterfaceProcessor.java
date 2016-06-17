/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for cc:interface.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/cc", localName = "interface")
public class InterfaceProcessor extends ServeAttachedObjectProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        processValueExpressionAttribute(context, parent, "componentType", String.class);
        super.process(context, parent, 0);
    }
}
