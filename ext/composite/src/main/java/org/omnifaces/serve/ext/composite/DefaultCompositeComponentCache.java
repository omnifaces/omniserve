/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;

/**
 * The default composite component cache.
 */
@ApplicationScoped
@Default
public class DefaultCompositeComponentCache implements CompositeComponentCache {

    /**
     * Stores the cache size constant.
     */
    private static final int CACHE_SIZE = 25;

    /**
     * Stores the cached implementation processors.
     */
    private final transient Map<String, ServeTagProcessor> implementationProcessors;

    /**
     * Stores the cached interface processors.
     */
    private final transient Map<String, ServeTagProcessor> interfaceProcessors;

    /**
     * Constructor.
     */
    public DefaultCompositeComponentCache() {
        implementationProcessors = Collections.synchronizedMap(new LinkedHashMap<String, ServeTagProcessor>() {
            private static final long serialVersionUID = 8300976593414373625L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<String, ServeTagProcessor> eldest) {
                return size() > CACHE_SIZE;
            }

        });
        interfaceProcessors = Collections.synchronizedMap(new LinkedHashMap<String, ServeTagProcessor>() {

            @Override
            protected boolean removeEldestEntry(Map.Entry<String, ServeTagProcessor> eldest) {
                return size() > CACHE_SIZE;
            }

        });
    }

    /**
     * Get the implementation processor.
     *
     * @param viewId the view id.
     * @return the implementation processor, or <code>null</code> if not found.
     */
    @Override
    public ServeTagProcessor getImplementation(String viewId) {
        return implementationProcessors.get(viewId);
    }

    /**
     * Get the interface processor.
     *
     * @param viewId the view id.
     * @return the interface processor, or <code>null</code> if not found.
     */
    @Override
    public ServeTagProcessor getInterface(String viewId) {
        return interfaceProcessors.get(viewId);
    }

    /**
     * Put the implementation processor.
     *
     * @param viewId the view id.
     * @param processor the implementation processor.
     */
    @Override
    public void putImplementation(String viewId, ServeTagProcessor processor) {
        implementationProcessors.put(viewId, processor);
    }

    /**
     * Put the interface processor.
     *
     * @param viewId the view id.
     * @param processor the interface processor.
     */
    @Override
    public void putInterface(String viewId, ServeTagProcessor processor) {
        interfaceProcessors.put(viewId, processor);
    }
}
