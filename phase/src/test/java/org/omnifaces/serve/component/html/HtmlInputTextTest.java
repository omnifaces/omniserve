/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlInputText.
 */
public class HtmlInputTextTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlInputText inputText = new HtmlInputText();
        assertEquals("org.omnifaces.serve.component.html", inputText.getFamily());
    }
}
