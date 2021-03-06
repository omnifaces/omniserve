/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlSelect.
 */
public class HtmlSelectTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlSelect select = new HtmlSelect();
        assertEquals("org.omnifaces.serve.component.html", select.getFamily());
    }
}
