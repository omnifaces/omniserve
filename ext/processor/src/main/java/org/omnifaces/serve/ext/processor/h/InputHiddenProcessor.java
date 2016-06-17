/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlInputHidden;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:inputHidden.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "inputHidden")
public class InputHiddenProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlInputHidden component = createComponent(HtmlInputHidden.class,
                "org.omnifaces.serve.component.html.HtmlInputHidden", context, parent, index);

        processEditableValueHolderAttributes(context, component);
        processValueExpressionAttribute(context, component, "id", String.class);
        processValueHolderAttributes(context, component);

        processValueExpressionAttribute(context, component, "converterMessage", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "requiredMessage", String.class);
        processValueExpressionAttribute(context, component, "validatorMessage", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
