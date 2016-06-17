/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlInputCheckbox.
 */
public class HtmlInputCheckboxTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlInputCheckbox inputCheckbox = new HtmlInputCheckbox();
        assertEquals("org.omnifaces.serve.component.html", inputCheckbox.getFamily());
    }
}
