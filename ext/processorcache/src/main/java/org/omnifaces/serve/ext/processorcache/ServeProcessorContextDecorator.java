/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processorcache;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import org.omnifaces.serve.ext.processor.DefaultServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeDefaultHandler2;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;

/**
 * A decorator around the DefaultServeProcessorContext for processor caching.
 */
@Decorator
@Priority(1000)
public abstract class ServeProcessorContextDecorator extends DefaultServeProcessorContext {

    /**
     * Inject the processor cache.
     */
    @Inject
    private ProcessorCache processorCache;

    /**
     * Inject the delegate.
     */
    @Inject
    @Delegate
    @Any
    private ServeProcessorContext context;

    /**
     * Create the processor.
     *
     * @param viewId the view id.
     * @return the processor.
     */
    @Override
    public ServeTagProcessor createProcessor(String viewId) {
        ServeTagProcessor result = processorCache.get(viewId);

        if (result == null) {
            result = context.createProcessor(viewId);
            processorCache.put(viewId, result);
        }

        return result;
    }

    @Override
    public ServeTagProcessor createProcessor(String viewId, ServeDefaultHandler2 defaultHandler2) {
        return context.createProcessor(viewId, defaultHandler2);
    }

}
