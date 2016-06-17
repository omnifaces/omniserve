/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlOutputLink;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:outputLink.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "outputLink")
public class OutputLinkProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlOutputLink component = createComponent(HtmlOutputLink.class,
                "org.omnifaces.serve.component.html.HtmlOutputLink", context, parent, index);

        processValueHolderAttributes(context, component);
        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "accesskey", String.class);
        processValueExpressionAttribute(context, component, "charset", String.class);
        processValueExpressionAttribute(context, component, "coords", String.class);
        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "disabled", boolean.class);
        processValueExpressionAttribute(context, component, "hreflang", String.class);
        processValueExpressionAttribute(context, component, "lang", String.class);
        processValueExpressionAttribute(context, parent, "onblur", String.class);
        processValueExpressionAttribute(context, parent, "onfocus", String.class);
        processEventAttributes(context, parent);
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
