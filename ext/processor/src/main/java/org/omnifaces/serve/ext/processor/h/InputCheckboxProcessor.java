/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlInputCheckbox;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:inputCheckbox.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "inputCheckbox")
public class InputCheckboxProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlInputCheckbox component = createComponent(HtmlInputCheckbox.class,
                "org.omnifaces.serve.component.html.HtmlInputCheckbox", context, parent, index);

        processEditableValueHolderAttributes(context, component);
        processEventAttributes(context, component);
        processValueExpressionAttribute(context, component, "id", String.class);
        processValueHolderAttributes(context, component);

        processValueExpressionAttribute(context, component, "converterMessage", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "requiredMessage", String.class);
        processValueExpressionAttribute(context, component, "validatorMessage", String.class);
        processValueExpressionAttribute(context, component, "accesskey", String.class);
        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "disabled", boolean.class);
        processValueExpressionAttribute(context, component, "label", String.class);
        processValueExpressionAttribute(context, component, "onblur", String.class);
        processValueExpressionAttribute(context, component, "onchange", String.class);
        processValueExpressionAttribute(context, component, "onfocus", String.class);
        processValueExpressionAttribute(context, component, "onselect", String.class);
        processValueExpressionAttribute(context, component, "readonly", boolean.class);
        processValueExpressionAttribute(context, component, "role", String.class);
        processValueExpressionAttribute(context, component, "style", String.class);
        processValueExpressionAttribute(context, component, "styleClass", String.class);
        processValueExpressionAttribute(context, component, "tabindex", String.class);
        processValueExpressionAttribute(context, component, "title", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
