/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.validator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for ServeValidatorLiteral.
 */
public class ServeValidatorLiteralTest {

    /**
     * Test value method.
     */
    @Test
    public void testValue() {
        ServeValidatorLiteral literal = new ServeValidatorLiteral("value");
        assertEquals("value", literal.value());
    }
}
