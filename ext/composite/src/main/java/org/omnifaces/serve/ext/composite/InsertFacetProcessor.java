/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeAttachedObjectProcessor;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.template.TemplateProcessor;

/**
 * The processor for cc:insertFacet.
 */
@TemplateProcessor(uri = "http://www.omnifaces.org/serve/ext/cc", localName = "insertFacet")
public class InsertFacetProcessor extends ServeAttachedObjectProcessor {

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        UICompositeComponent container = getClosestParent(parent, UICompositeComponent.class);
        String facetName = (String) context.evaluate(attributes.get("name").getValue(), String.class);
        UIComponent facet = container.getChildren().get(0).getFacet(facetName);
        parent.getFacets().put(facetName, facet);
    }
}
