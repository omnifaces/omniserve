/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlInputSecret.
 */
public class HtmlInputSecretTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlInputSecret inputSecret = new HtmlInputSecret();
        assertEquals("org.omnifaces.serve.component.html", inputSecret.getFamily());
    }
}
