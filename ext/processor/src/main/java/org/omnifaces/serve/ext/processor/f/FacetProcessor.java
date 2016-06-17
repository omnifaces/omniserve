/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor.f;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIPanel;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for f:facet.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/f", localName = "facet")
public class FacetProcessor extends ServeAttachedObjectProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        UIPanel facet = (UIPanel) context.createComponent("org.omnifaces.serve.component.UIPanel");
        String facetName = attributes.get("name").getValue();
        parent.getFacets().put(facetName, facet);
        super.process(context, facet, 0);
    }
}
