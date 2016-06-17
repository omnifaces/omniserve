/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.renderercache;

import static org.junit.Assert.*;
import org.junit.Test;
import org.omnifaces.serve.renderkit.Renderer;

/**
 * The JUnit tests for DefaultRendererCache.
 */
public class DefaultRendererCacheTest {

    /**
     * Test get method.
     */
    @Test
    public void testGet() {
        DefaultRendererCache cache = new DefaultRendererCache();
        Renderer result = cache.get("", "", "");
        assertNull(result);
    }

    /**
     * Test put method.
     */
    @Test
    public void testPut() {
        DefaultRendererCache cache = new DefaultRendererCache();
        cache.put("", "test", "test", new Renderer() {

            @Override
            public void encode(Object context, Object component) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void decode(Object context, Object component) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        assertNotNull(cache.get("", "test", "test"));
    }
}
