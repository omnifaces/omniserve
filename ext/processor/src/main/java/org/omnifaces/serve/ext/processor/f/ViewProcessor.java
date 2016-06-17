/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.f;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIPanel;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:view.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/f", localName = "view")
public class ViewProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        UIPanel placeHolder = createComponent(UIPanel.class,
                "org.omnifaces.serve.component.UIPanel", context, parent, index);
        super.process(context, placeHolder, 0);
    }
}
