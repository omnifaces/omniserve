/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIPanel;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for ui:composition.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/ui", localName = "composition")
public class CompositionProcessor extends ServeTagProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        UIPanel placeHolder;

        placeHolder = new UIPanel();
        parent.getChildren().add(placeHolder);

        String src = attributes.get("template").getValue();
        ServeTagProcessor processor = context.createProcessor(src);
        processor.process(context, placeHolder, 0);

        UIPanel placeHolderFacet = new UIPanel();
        placeHolder.getFacets().put(CompositionProcessor.class.getName(), placeHolderFacet);

        super.process(context, placeHolderFacet, 0);

        context.getContext().getViewRoot().getChildren().clear();
        context.getContext().getViewRoot().getChildren().add(placeHolder);
        context.setProcessing(false);
    }
}
