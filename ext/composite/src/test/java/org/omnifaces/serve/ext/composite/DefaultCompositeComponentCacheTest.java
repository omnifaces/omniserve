/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import static org.junit.Assert.*;
import org.junit.Test;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;

/**
 * The JUnit tests for DefaultCompositeComponentCache.
 */
public class DefaultCompositeComponentCacheTest {

    /**
     * Test getImplementation method.
     */
    @Test
    public void testGetImplementation() {
        DefaultCompositeComponentCache cache = new DefaultCompositeComponentCache();
        assertNull(cache.getImplementation("/viewId.xhtml"));
        cache.putImplementation("/viewId.xhtml", new ServeTagProcessor());
        assertNotNull(cache.getImplementation("/viewId.xhtml"));
    }

    /**
     * Test getInterface method.
     */
    @Test
    public void testGetInterface() {
        DefaultCompositeComponentCache cache = new DefaultCompositeComponentCache();
        assertNull(cache.getInterface("/viewId.xhtml"));
        cache.putInterface("/viewId.xhtml", new ServeTagProcessor());
        assertNotNull(cache.getInterface("/viewId.xhtml"));
    }
}
