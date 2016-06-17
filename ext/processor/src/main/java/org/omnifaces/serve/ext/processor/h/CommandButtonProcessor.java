/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlCommandButton;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:commandButton.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "commandButton")
public class CommandButtonProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlCommandButton component = createComponent(HtmlCommandButton.class,
                "org.omnifaces.serve.component.html.HtmlCommandButton", context, parent, index);

        processActionSourceAttributes(context, component);
        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "value", Object.class);
        processValueExpressionAttribute(context, component, "accesskey", String.class);
        processValueExpressionAttribute(context, component, "alt", String.class);
        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "disabled", boolean.class);
        processValueExpressionAttribute(context, component, "image", String.class);
        processValueExpressionAttribute(context, component, "label", String.class);
        processValueExpressionAttribute(context, component, "lang", String.class);
        processValueExpressionAttribute(context, component, "onblur", String.class);
        processValueExpressionAttribute(context, component, "onchange", String.class);
        processValueExpressionAttribute(context, component, "onfocus", String.class);
        processEventAttributes(context, component);
        processValueExpressionAttribute(context, component, "onselect", String.class);
        processValueExpressionAttribute(context, component, "readonly", boolean.class);
        processValueExpressionAttribute(context, component, "role", String.class);
        processValueExpressionAttribute(context, component, "style", String.class);
        processValueExpressionAttribute(context, component, "styleClass", String.class);
        processValueExpressionAttribute(context, component, "tabindex", String.class);
        processValueExpressionAttribute(context, component, "title", String.class);
        processValueExpressionAttribute(context, component, "type", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
