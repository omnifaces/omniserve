/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.zxing;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for zxing:itfBarcode.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/zxing", localName = "itfBarcode")
public class ItfBarcodeProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlItfBarcode component = createComponent(HtmlItfBarcode.class,
                "org.omnifaces.serve.ext.zxing.HtmlItfBarcode", context, parent, index);

        processValueExpressionAttribute(context, component, "id", String.class);
        processValueExpressionAttribute(context, component, "rendered", boolean.class);
        processValueExpressionAttribute(context, component, "value", Object.class);
        processValueExpressionAttribute(context, component, "height", String.class);
        processValueExpressionAttribute(context, component, "width", String.class);
        processPassthroughAttributes(context, component);

        super.process(context, component, 0);
    }
}
