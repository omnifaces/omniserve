/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The JUnit tests for HtmlButton.
 */
public class HtmlButtonTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlButton button = new HtmlButton();
        assertEquals("org.omnifaces.serve.component.html", button.getFamily());
    }
}
