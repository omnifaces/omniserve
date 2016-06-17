/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;

/**
 * The no-caching composite component cache.
 */
@ApplicationScoped
@Alternative
public class NoCachingCompositeComponentCache implements CompositeComponentCache {

    /**
     * Constructor.
     */
    public NoCachingCompositeComponentCache() {
    }

    /**
     * Get the implementation processor.
     *
     * @param viewId the view id.
     * @return <code>null</code>.
     */
    @Override
    public ServeTagProcessor getImplementation(String viewId) {
        return null;
    }

    /**
     * Get the interface processor.
     *
     * @param viewId the view id.
     * @return <code>null</code>.
     */
    @Override
    public ServeTagProcessor getInterface(String viewId) {
        return null;
    }

    /**
     * Put the implementation processor.
     *
     * @param viewId the view id.
     * @param processor the implementation processor.
     */
    @Override
    public void putImplementation(String viewId, ServeTagProcessor processor) {
    }

    /**
     * Put the interface processor.
     *
     * @param viewId the view id.
     * @param processor the interface processor.
     */
    @Override
    public void putInterface(String viewId, ServeTagProcessor processor) {
    }
}
