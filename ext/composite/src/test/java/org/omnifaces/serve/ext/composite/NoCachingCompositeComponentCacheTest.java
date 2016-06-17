/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import static org.junit.Assert.*;
import org.junit.Test;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;

/**
 * The JUnit tests for NoCachingCompositeComponentCache.
 */
public class NoCachingCompositeComponentCacheTest {

    /**
     * Test getImplementation method.
     */
    @Test
    public void testGetImplementation() {
        NoCachingCompositeComponentCache cache = new NoCachingCompositeComponentCache();
        assertNull(cache.getImplementation("/viewId.xhtml"));
        cache.putImplementation("/viewId.xhtml", new ServeTagProcessor());
        assertNull(cache.getImplementation("/viewId.xhtml"));
    }

    /**
     * Test getInterface method.
     */
    @Test
    public void testGetInterface() {
        NoCachingCompositeComponentCache cache = new NoCachingCompositeComponentCache();
        assertNull(cache.getInterface("/viewId.xhtml"));
        cache.putInterface("/viewId.xhtml", new ServeTagProcessor());
        assertNull(cache.getInterface("/viewId.xhtml"));
    }
}
