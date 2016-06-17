/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlMessage;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:message.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "message")
public class MessageProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlMessage component = createComponent(HtmlMessage.class,
                "org.omnifaces.serve.component.html.HtmlMessage", context, parent, index);

        processValueExpressionAttribute(context, component, "for", String.class);
        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "showDetail", boolean.class);
        processValueExpressionAttribute(context, component, "showSummary", boolean.class);
        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "errorClass", String.class);
        processValueExpressionAttribute(context, component, "errorStyle", String.class);
        processValueExpressionAttribute(context, component, "fatalClass", String.class);
        processValueExpressionAttribute(context, component, "fatalStyle", String.class);
        processValueExpressionAttribute(context, component, "infoClass", String.class);
        processValueExpressionAttribute(context, component, "infoStyle", String.class);
        processValueExpressionAttribute(context, component, "lang", String.class);
        processValueExpressionAttribute(context, component, "role", String.class);
        processValueExpressionAttribute(context, component, "style", String.class);
        processValueExpressionAttribute(context, component, "styleClass", String.class);
        processValueExpressionAttribute(context, component, "title", String.class);
        processValueExpressionAttribute(context, component, "tooltip", String.class);
        processValueExpressionAttribute(context, component, "warnClass", String.class);
        processValueExpressionAttribute(context, component, "warnStyle", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
