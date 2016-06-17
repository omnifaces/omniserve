/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlInputTextarea.
 */
public class HtmlInputTextareaTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlInputTextarea inputTextarea = new HtmlInputTextarea();
        assertEquals("org.omnifaces.serve.component.html", inputTextarea.getFamily());
    }
}
