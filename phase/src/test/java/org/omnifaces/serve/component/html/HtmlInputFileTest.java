/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlInputFile.
 */
public class HtmlInputFileTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlInputFile inputFile = new HtmlInputFile();
        assertEquals("org.omnifaces.serve.component.html", inputFile.getFamily());
    }
}
