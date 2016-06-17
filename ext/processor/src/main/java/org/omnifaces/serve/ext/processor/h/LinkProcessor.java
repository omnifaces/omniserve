/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlLink;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:link.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "link")
public class LinkProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlLink component = createComponent(HtmlLink.class,
                "org.omnifaces.serve.component.html.HtmlLink", context, parent, index);

        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "outcome", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "value", Object.class);
        processValueExpressionAttribute(context, component, "accesskey", String.class);
        processValueExpressionAttribute(context, component, "charset", String.class);
        processValueExpressionAttribute(context, component, "coords", String.class);
        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "disabled", boolean.class);
        processValueExpressionAttribute(context, component, "fragment", String.class);
        processValueExpressionAttribute(context, component, "hreflang", String.class);
        processValueExpressionAttribute(context, component, "lang", String.class);
        processValueExpressionAttribute(context, component, "onblur", String.class);
        processValueExpressionAttribute(context, component, "onfocus", String.class);
        processEventAttributes(context, component);
        processValueExpressionAttribute(context, component, "rel", String.class);
        processValueExpressionAttribute(context, component, "rev", String.class);
        processValueExpressionAttribute(context, component, "role", String.class);
        processValueExpressionAttribute(context, component, "shape", String.class);
        processValueExpressionAttribute(context, component, "style", String.class);
        processValueExpressionAttribute(context, component, "styleClass", String.class);
        processValueExpressionAttribute(context, component, "tabindex", String.class);
        processValueExpressionAttribute(context, component, "target", String.class);
        processValueExpressionAttribute(context, component, "title", String.class);
        processValueExpressionAttribute(context, component, "type", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
