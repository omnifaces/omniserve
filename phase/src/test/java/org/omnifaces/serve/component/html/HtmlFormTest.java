/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlForm.
 */
public class HtmlFormTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlForm form = new HtmlForm();
        assertEquals("org.omnifaces.serve.component.html", form.getFamily());
    }
}
