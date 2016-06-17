/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlDoctype;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:doctype.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "doctype")
public class DoctypeProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlDoctype component = createComponent(HtmlDoctype.class,
                "org.omnifaces.serve.component.html.HtmlDoctype", context, parent, index);

        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "value", Object.class);
        processValueExpressionAttribute(context, component, "public", String.class);
        processValueExpressionAttribute(context, component, "rootElement", String.class);
        processValueExpressionAttribute(context, component, "system", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
