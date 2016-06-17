/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for ui:include.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/ui", localName = "include")
public class IncludeProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        UIInclude include;
        include = new UIInclude();
        parent.getChildren().add(include);
        String src = (String) context.evaluate(attributes.get("src").getValue(), String.class);

        /*
         * Execute the embedded ui:param tags.
         */
        super.process(context, include, 0);

        /*
         * Include the page.
         */
        ServeTagProcessor processor = context.createProcessor(src);
        processor.process(context, include, 0);
    }
}
