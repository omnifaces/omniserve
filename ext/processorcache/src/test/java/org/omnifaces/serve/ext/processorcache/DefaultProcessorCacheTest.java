/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.processorcache;

import static org.junit.Assert.*;
import org.junit.Test;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;

/**
 * The JUnit tests for DefaultProcessorCache.
 */
public class DefaultProcessorCacheTest {

    /**
     * Test get method.
     */
    @Test
    public void testGetInterface() {
        DefaultProcessorCache cache = new DefaultProcessorCache();
        assertNull(cache.get("/viewId.xhtml"));
        cache.put("/viewId.xhtml", new ServeTagProcessor());
        assertNotNull(cache.get("/viewId.xhtml"));
    }
}
