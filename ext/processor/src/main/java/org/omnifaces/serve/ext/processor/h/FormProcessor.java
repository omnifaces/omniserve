/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlForm;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:form.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "form")
public class FormProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlForm component = createComponent(HtmlForm.class,
                "org.omnifaces.serve.component.html.HtmlForm", context, parent, index);

        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "prependId", boolean.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "accept", String.class);
        processValueExpressionAttribute(context, component, "acceptcharset", String.class);
        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "enctype", String.class);
        processValueExpressionAttribute(context, component, "lang", String.class);
        processEventAttributes(context, component);
        processValueExpressionAttribute(context, component, "onreset", String.class);
        processValueExpressionAttribute(context, component, "onsubmit", String.class);
        processValueExpressionAttribute(context, component, "role", String.class);
        processValueExpressionAttribute(context, component, "style", String.class);
        processValueExpressionAttribute(context, component, "styleClass", String.class);
        processValueExpressionAttribute(context, component, "title", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
