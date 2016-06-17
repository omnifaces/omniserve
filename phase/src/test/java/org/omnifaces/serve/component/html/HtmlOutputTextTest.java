/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlOutputText.
 */
public class HtmlOutputTextTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlOutputText outputText = new HtmlOutputText();
        assertEquals("org.omnifaces.serve.component.html", outputText.getFamily());
    }
}
