/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.template.ProcessorContext;
import org.omnifaces.template.TagProcessor;
import org.omnifaces.template.TagProcessorFactory;
import org.omnifaces.template.TemplateProcessorLiteral;

/**
 * The Serve tag processor factory.
 */
@ApplicationScoped
@Default
public class ServeTagProcessorFactory implements TagProcessorFactory<ProcessorContext, UIComponent> {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Get the tag processor.
     *
     * @param uri the URI.
     * @param localName the local name.
     * @return the tag processor or null if not found.
     */
    @Override
    public TagProcessor<ProcessorContext, UIComponent> getTagProcessor(String uri, String localName) {
        TagProcessor<ProcessorContext, UIComponent> result = null;
        if (hasTagProcessor(uri, localName)) {
            result = (TagProcessor<ProcessorContext, UIComponent>) cdiManager.getInstance(Object.class,
                    new TemplateProcessorLiteral(uri, localName));
        }
        return result;
    }

    /**
     * Do we have a tag processor for?
     *
     * @param uri the URI.
     * @param localName the local name.
     * @return true if we have a tag processor, false otherwise.
     */
    @Override
    public boolean hasTagProcessor(String uri, String localName) {
        return cdiManager.exists(Object.class, new TemplateProcessorLiteral(uri, localName));
    }
}
