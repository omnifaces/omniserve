/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlOutputFormat;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:outputFormat.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "outputFormat")
public class OutputFormatProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlOutputFormat component = createComponent(HtmlOutputFormat.class,
                "org.omnifaces.serve.component.html.HtmlOutputFormat", context, parent, index);

        processValueHolderAttributes(context, component);
        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "escape", boolean.class);
        processValueExpressionAttribute(context, component, "lang", String.class);
        processValueExpressionAttribute(context, component, "role", String.class);
        processValueExpressionAttribute(context, component, "style", String.class);
        processValueExpressionAttribute(context, component, "styleClass", String.class);
        processValueExpressionAttribute(context, component, "title", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
