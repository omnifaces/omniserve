/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.chartjs;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for chartjs:barChart.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/chartjs", localName = "barChart")
public class BarChartProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlBarChart component = createComponent(HtmlBarChart.class,
                "org.omnifaces.serve.ext.chartjs.HtmlBarChart", context, parent, index);

        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "value", Object.class);
        processValueExpressionAttribute(context, component, "height", String.class);
        processValueExpressionAttribute(context, component, "width", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
