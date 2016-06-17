/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.f;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIParameter;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:param.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/f", localName = "param")
public class ParamProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        UIParameter child = createComponent(UIParameter.class,
                "org.omnifaces.serve.component.UIParameter", context, parent, index);

        processValueExpressionAttribute(context, child, "id", String.class);
        processValueExpressionAttribute(context, child, "name", String.class);
        processValueExpressionAttribute(context, child, "value", Object.class);
        processValueExpressionAttribute(context, child, "disable", boolean.class);

        super.process(context, child, 0);
    }
}
