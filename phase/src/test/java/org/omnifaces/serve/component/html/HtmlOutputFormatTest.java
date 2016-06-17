/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlOutputFormat.
 */
public class HtmlOutputFormatTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlOutputFormat outputFormat = new HtmlOutputFormat();
        assertEquals("org.omnifaces.serve.component.html", outputFormat.getFamily());
    }
}
