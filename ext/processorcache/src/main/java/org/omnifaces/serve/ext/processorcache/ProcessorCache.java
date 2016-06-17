/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processorcache;

import org.omnifaces.serve.ext.processor.ServeTagProcessor;

/**
 * A processor cache.
 */
public interface ProcessorCache {

    /**
     * Get the processor from the cache.
     *
     * @param viewId the view id.
     * @return the processor, or null if not found.
     */
    ServeTagProcessor get(String viewId);

    /**
     * Put the processor in the cache.
     *
     * @param viewId the view id.
     * @param processor the processor.
     */
    void put(String viewId, ServeTagProcessor processor);
}
