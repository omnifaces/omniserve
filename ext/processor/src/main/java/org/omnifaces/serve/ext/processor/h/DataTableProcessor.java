/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlDataTable;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:dataTable.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "dataTable")
public class DataTableProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlDataTable component = createComponent(HtmlDataTable.class,
                "org.omnifaces.serve.component.html.HtmlDataTable", context, parent, index);

        processValueExpressionAttribute(context, component, "first", int.class);
        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "rows", int.class);
        processValueExpressionAttribute(context, component, "value", Object.class);
        processValueExpressionAttribute(context, component, "var", String.class);
        processValueExpressionAttribute(context, component, "bgcolor", String.class);
        processValueExpressionAttribute(context, component, "bodyrows", String.class);
        processValueExpressionAttribute(context, component, "border", int.class);
        processValueExpressionAttribute(context, component, "captionClass", String.class);
        processValueExpressionAttribute(context, component, "captionStyle", String.class);
        processValueExpressionAttribute(context, component, "cellpadding", String.class);
        processValueExpressionAttribute(context, component, "cellspacing", String.class);
        processValueExpressionAttribute(context, component, "columnClasses", String.class);
        processValueExpressionAttribute(context, component, "dir", String.class);
        processValueExpressionAttribute(context, component, "footerClass", String.class);
        processValueExpressionAttribute(context, component, "frame", String.class);
        processValueExpressionAttribute(context, component, "headerClass", String.class);
        processValueExpressionAttribute(context, component, "lang", String.class);
        processEventAttributes(context, component);
        processValueExpressionAttribute(context, component, "role", String.class);
        processValueExpressionAttribute(context, component, "rowClasses", String.class);
        processValueExpressionAttribute(context, component, "rules", String.class);
        processValueExpressionAttribute(context, component, "style", String.class);
        processValueExpressionAttribute(context, component, "styleClass", String.class);
        processValueExpressionAttribute(context, component, "summary", String.class);
        processValueExpressionAttribute(context, component, "title", String.class);
        processValueExpressionAttribute(context, component, "width", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
