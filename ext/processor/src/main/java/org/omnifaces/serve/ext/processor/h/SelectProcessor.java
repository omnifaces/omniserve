/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.h;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.html.HtmlSelect;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for h:select.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/h", localName = "select")
public class SelectProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {

        HtmlSelect component = createComponent(HtmlSelect.class,
                "org.omnifaces.serve.component.html.HtmlSelect", context, parent, index);

        processValueExpressionAttribute(context, component, "id", String.class);
        processEditableValueHolderAttributes(context, component);
        processValueHolderAttributes(context, component);

        super.process(context, component, 0);
    }
}
