/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import org.omnifaces.serve.ext.processor.ServeTagProcessor;

/**
 * Defines cache for composite components.
 */
public interface CompositeComponentCache {

    /**
     * Get the implementation processor.
     *
     * @param viewId the viewId.
     * @return the implementation processor or <code>null</code> if not found.
     */
    ServeTagProcessor getImplementation(String viewId);

    /**
     * Get the interface processor.
     *
     * @param viewId the viewId.
     * @return the interface processor or <code>null</code> if not found.
     */
    ServeTagProcessor getInterface(String viewId);

    /**
     * Put the implementation processor.
     *
     * @param viewId the view id.
     * @param processor the implementation processor.
     */
    void putImplementation(String viewId, ServeTagProcessor processor);

    /**
     * Put the interface processor.
     *
     * @param viewId the view id.
     * @param processor the interface processor.
     */
    void putInterface(String viewId, ServeTagProcessor processor);
}
