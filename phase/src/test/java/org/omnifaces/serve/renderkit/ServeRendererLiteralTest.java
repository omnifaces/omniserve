/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for ServeRendererLiteral.
 */
public class ServeRendererLiteralTest {

    /**
     * Test renderKitId method.
     */
    @Test
    public void testRenderKitId() {
        ServeRendererLiteral literal = new ServeRendererLiteral("renderKitId", null, null);
        assertEquals("renderKitId", literal.renderKitId());
    }

    /**
     * Test rendererType method.
     */
    @Test
    public void testRendererType() {
        ServeRendererLiteral literal = new ServeRendererLiteral(null, null, "rendererType");
        assertEquals("rendererType", literal.rendererType());
    }

    /**
     * Test componentFamily method.
     */
    @Test
    public void testComponentFamily() {
        ServeRendererLiteral literal = new ServeRendererLiteral(null, "componentFamily", null);
        assertEquals("componentFamily", literal.componentFamily());
    }
}
