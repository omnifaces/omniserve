/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * The JUnit tests for UIOutput.
 */
public class UIOutputTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        UIOutput output = new UIOutput();
        assertEquals("org.omnifaces.serve.component", output.getFamily());
    }

    /**
     * Test getConverter method.
     */
    @Test
    public void testGetConverter() {
        UIOutput output = new UIOutput();
        output.setConverter(new TestConverter());
        assertNotNull(output.getConverter());
    }
}
