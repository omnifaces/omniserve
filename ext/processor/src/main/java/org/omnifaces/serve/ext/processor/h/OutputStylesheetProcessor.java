/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlOutputStylesheet;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:outputStylesheet.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "outputStylesheet")
public class OutputStylesheetProcessor extends ServeAttachedObjectProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlOutputStylesheet component = createComponent(HtmlOutputStylesheet.class,
                "org.omnifaces.serve.component.html.HtmlOutputStylesheet", context, parent, index);

        processValueExpressionAttribute(context, component, "library", String.class);
        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "media", String.class);
        processValueExpressionAttribute(context, component, "name", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
