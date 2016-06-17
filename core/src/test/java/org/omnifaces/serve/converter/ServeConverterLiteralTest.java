/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.converter;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for ServeConverterLiteral.
 */
public class ServeConverterLiteralTest {

    /**
     * Test value method.
     */
    @Test
    public void testValue() {
        ServeConverterLiteral literal = new ServeConverterLiteral("value", null);
        assertEquals("value", literal.value());
    }

    /**
     * Test forClass method.
     */
    @Test
    public void testForClass() {
        ServeConverterLiteral literal = new ServeConverterLiteral(null, Object.class);
        assertEquals(Object.class, literal.forClass());
    }
}
