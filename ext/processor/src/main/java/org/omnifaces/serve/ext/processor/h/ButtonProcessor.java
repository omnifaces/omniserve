/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlButton;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:button.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "button")
public class ButtonProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlButton component = createComponent(HtmlButton.class,
                "org.omnifaces.serve.component.html.HtmlButton", context, parent, index);

        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "outcome", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "value", Object.class);
        processValueExpressionAttribute(context, component, "accesskey", String.class);
        processValueExpressionAttribute(context, component, "alt", String.class);
        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "fragment", String.class);
        processValueExpressionAttribute(context, component, "image", String.class);
        processValueExpressionAttribute(context, component, "lang", String.class);
        processValueExpressionAttribute(context, component, "onblur", String.class);
        processValueExpressionAttribute(context, component, "onfocus", String.class);
        processEventAttributes(context, component);
        processValueExpressionAttribute(context, component, "role", String.class);
        processValueExpressionAttribute(context, component, "style", String.class);
        processValueExpressionAttribute(context, component, "styleClass", String.class);
        processValueExpressionAttribute(context, component, "tabindex", String.class);
        processValueExpressionAttribute(context, component, "title", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
