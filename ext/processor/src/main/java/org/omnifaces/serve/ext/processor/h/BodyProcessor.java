/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlBody;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:body.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "body")
public class BodyProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlBody component = createComponent(HtmlBody.class,
                "org.omnifaces.serve.component.html.HtmlBody", context, parent, index);

        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "lang", String.class);
        processValueExpressionAttribute(context, component, "onload", String.class);
        processValueExpressionAttribute(context, component, "onunload", String.class);
        processEventAttributes(context, component);
        processValueExpressionAttribute(context, component, "role", String.class);
        processValueExpressionAttribute(context, component, "shape", String.class);
        processValueExpressionAttribute(context, component, "style", String.class);
        processValueExpressionAttribute(context, component, "styleClass", String.class);
        processValueExpressionAttribute(context, component, "title", String.class);
        processValueExpressionAttribute(context, component, "type", String.class);
        processValueExpressionAttribute(context, component, "xmlns", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
