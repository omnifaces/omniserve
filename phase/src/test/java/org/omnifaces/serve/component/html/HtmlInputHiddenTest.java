/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlInputHidden.
 */
public class HtmlInputHiddenTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlInputHidden inputHidden = new HtmlInputHidden();
        assertEquals("org.omnifaces.serve.component.html", inputHidden.getFamily());
    }
}
