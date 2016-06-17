/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processorcache;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;

/**
 * A default processor cache.
 */
@ApplicationScoped
@Default
public class DefaultProcessorCache implements ProcessorCache {

    /**
     * Stores the cache size constant.
     */
    private static final int CACHE_SIZE = 25;

    /**
     * Stores the cached processors.
     */
    private final Map<String, ServeTagProcessor> processors;

    /**
     * Constructor.
     */
    public DefaultProcessorCache() {
        processors = Collections.synchronizedMap(new LinkedHashMap<String, ServeTagProcessor>() {
            private static final long serialVersionUID = 8300976593414373625L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<String, ServeTagProcessor> eldest) {
                return size() > CACHE_SIZE;
            }

        });
    }

    /**
     * Get the processor from the cache.
     *
     * @param viewId the view id.
     * @return the processor, or null if not found.
     */
    @Override
    public ServeTagProcessor get(String viewId) {
        return processors.get(viewId);
    }

    /**
     * Put the processor in the cache.
     *
     * @param viewId the view id.
     * @param processor the processor.
     */
    @Override
    public void put(String viewId, ServeTagProcessor processor) {
        processors.put(viewId, processor);
    }
}
