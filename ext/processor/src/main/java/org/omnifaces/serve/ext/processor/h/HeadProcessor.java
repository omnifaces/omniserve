/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlHead;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:head.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "head")
public class HeadProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlHead component = createComponent(HtmlHead.class,
                "org.omnifaces.serve.component.html.HtmlHead", context, parent, index);

        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "lang", String.class);
        processValueExpressionAttribute(context, component, "xmlns", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
