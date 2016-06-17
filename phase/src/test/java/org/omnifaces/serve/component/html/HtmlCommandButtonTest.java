/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlCommandButton.
 */
public class HtmlCommandButtonTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlCommandButton commandButton = new HtmlCommandButton();
        assertEquals("org.omnifaces.serve.component.html", commandButton.getFamily());
    }
}
