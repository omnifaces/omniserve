/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.converter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * The JUnit tests for ConverterException.
 */
public class ConverterExceptionTest {

    /**
     * Test constructor.
     */
    @Test
    public void testConstructor() {
        ConverterException exception = new ConverterException(new RuntimeException());
        assertNotNull(exception.getCause());
    }

    /**
     * Test constructor.
     */
    @Test
    public void testConstructor2() {
        ConverterException exception = new ConverterException();
        assertNull(exception.getCause());
    }
}
