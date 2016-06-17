/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.event;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for ServeActionListenerLiteral.
 */
public class ServeActionListenerLiteralTest {

    /**
     * Test value method.
     */
    @Test
    public void testValue() {
        ServeActionListenerLiteral literal = new ServeActionListenerLiteral("DEFAULT");
        assertEquals("DEFAULT", literal.value());
    }
}
