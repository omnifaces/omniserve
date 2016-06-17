/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.converter;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The JUnit tests for DateTimeConverter.
 */
public class DateTimeConverterTest {

    /**
     * Test getAsObject method.
     */
    @Test
    public void testGetAsObject() {
        DateTimeConverter converter = new DateTimeConverter();
        assertNull(converter.getAsObject(""));
    }

    /**
     * Test getAsObject method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAsObject2() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.getAsObject("1/1/2001");
    }

    /**
     * Test getAsObject method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAsObject3() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setPattern("MM/dd/YYYY");
        converter.getAsObject("1/1/2001");
    }

    /**
     * Test getAsObject method.
     */
    @Test
    public void testGetAsObject4() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setPattern("MM/dd/YYYY");
        converter.setLocale(Locale.US);
        assertNotNull(converter.getAsObject("1/1/2001"));
    }

    /**
     * Test getAsObject method.
     */
    @Test
    public void testGetAsObject5() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setPattern("MM/dd/YYYY");
        converter.setLocale(Locale.US);
        converter.setTimeZone(TimeZone.getTimeZone("CST"));
        assertNotNull(converter.getAsObject("1/1/2001"));
    }

    /**
     * Test getAsObject method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAsObject6() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setPattern("MM/dd/YYYY");
        converter.setLocale(Locale.US);
        converter.setTimeZone(TimeZone.getTimeZone("CST"));
        converter.getAsObject("1a/1/2001");
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString() {
        DateTimeConverter converter = new DateTimeConverter();
        assertEquals("", converter.getAsString(null));
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString2() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setPattern("MM/dd/YYYY");
        converter.setLocale(Locale.US);
        assertNotNull(converter.getAsString(new Date()));
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString3() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setPattern("MM/dd/YYYY");
        converter.setLocale(Locale.US);
        converter.setTimeZone(TimeZone.getTimeZone("CST"));
        assertNotNull(converter.getAsString(new Date()));
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString4() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setLocale(Locale.US);
        converter.setType("both");
        converter.setDateStyle("default");
        converter.setTimeStyle("default");
        assertNotNull(converter.getAsString(new Date()));
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString5() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setLocale(Locale.US);
        converter.setType("date");
        converter.setDateStyle("default");
        assertNotNull(converter.getAsString(new Date()));
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString6() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setLocale(Locale.US);
        converter.setType("time");
        converter.setTimeStyle("default");
        assertNotNull(converter.getAsString(new Date()));
    }

    /**
     * Test getAsString method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAsString7() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setLocale(Locale.US);
        converter.setType("bogus");
        converter.getAsString(new Date());
    }

    /**
     * Test getAsString method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAsString8() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setLocale(Locale.US);
        converter.setType("date");
        converter.setDateStyle(null);
        converter.getAsString(new Date());
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString9() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setLocale(Locale.US);
        converter.setType("date");
        converter.setDateStyle("short");
        converter.getAsString(new Date());
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString10() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setLocale(Locale.US);
        converter.setType("date");
        converter.setDateStyle("medium");
        converter.getAsString(new Date());
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString11() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setLocale(Locale.US);
        converter.setType("date");
        converter.setDateStyle("long");
        converter.getAsString(new Date());
    }

    /**
     * Test getAsString method.
     */
    @Test
    public void testGetAsString12() {
        DateTimeConverter converter = new DateTimeConverter();
        converter.setLocale(Locale.US);
        converter.setType("date");
        converter.setDateStyle("full");
        converter.getAsString(new Date());
    }
}
