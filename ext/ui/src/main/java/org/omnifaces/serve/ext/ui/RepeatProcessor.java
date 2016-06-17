/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for ui:repeat.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/ui", localName = "repeat")
public class RepeatProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        UIRepeat repeat = new UIRepeat();
        parent.getChildren().add(repeat);
        processValueExpressionAttribute(context, repeat, "value", Object.class);
        processValueExpressionAttribute(context, repeat, "var", String.class);
        processValueExpressionAttribute(context, repeat, "varStatus", String.class);
        super.process(context, repeat, 0);
    }
}
