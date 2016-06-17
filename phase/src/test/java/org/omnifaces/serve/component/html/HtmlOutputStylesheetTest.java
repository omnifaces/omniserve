/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlOutputStylesheet.
 */
public class HtmlOutputStylesheetTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlOutputStylesheet outputStylesheet = new HtmlOutputStylesheet();
        assertEquals("org.omnifaces.serve.component.html", outputStylesheet.getFamily());
    }
}
