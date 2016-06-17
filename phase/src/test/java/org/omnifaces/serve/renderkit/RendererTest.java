/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

import org.junit.Test;

/**
 * The JUnit tests for Renderer.
 */
public class RendererTest {

    /**
     * Test decode method.
     */
    @Test
    public void testDecode() {
        Renderer renderer = new Renderer() {
        };

        renderer.decode(null, null);
    }

    /**
     * Test encode method.
     */
    @Test
    public void testEncode() {
        Renderer renderer = new Renderer() {
        };

        renderer.encode(null, null);
    }
}
