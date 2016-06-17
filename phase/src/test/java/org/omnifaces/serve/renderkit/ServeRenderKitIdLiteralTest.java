/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The JUnit tests for ServeRenderKitIdLiteral.
 */
public class ServeRenderKitIdLiteralTest {

    /**
     * Test value method.
     */
    @Test
    public void testValue() {
        ServeRenderKitIdLiteral literal = new ServeRenderKitIdLiteral("value");
        assertEquals("value", literal.value());
    }
}
