/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.converter;

import static org.junit.Assert.*;
import org.junit.Test;
import org.omnifaces.serve.converter.ConverterException;

/**
 * The JUnit tests for LongConverter.
 */
public class LongConverterTest {

    /**
     * Test getAsObject method.
     */
    @Test
    public void testGetAsObject() {
        LongConverter converter = new LongConverter();
        assertNull(converter.getAsObject(""));
    }

    /**
     * Test getAsObject method.
     */
    @Test
    public void testGetAsObject2() {
        LongConverter converter = new LongConverter();
        assertEquals(1234L, converter.getAsObject("1234"));
    }

    /**
     * Test getAsObject method.
     */
    @Test(expected = ConverterException.class)
    public void testGetAsObject3() {
        LongConverter converter = new LongConverter();
        assertEquals(1234L, converter.getAsObject("1234a"));
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString() {
        LongConverter converter = new LongConverter();
        assertEquals("", converter.getAsString(null));
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString2() {
        LongConverter converter = new LongConverter();
        assertEquals("1234", converter.getAsString(1234L));
    }
}
