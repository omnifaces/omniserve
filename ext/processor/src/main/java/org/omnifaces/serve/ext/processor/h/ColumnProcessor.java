/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlColumn;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:column.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "column")
public class ColumnProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlColumn component = createComponent(HtmlColumn.class,
                "org.omnifaces.serve.component.html.HtmlColumn", context, parent, index);

        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "footerClass", String.class);
        processValueExpressionAttribute(context, component, "headerClass", String.class);
        processValueExpressionAttribute(context, component, "rowHeader", boolean.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
