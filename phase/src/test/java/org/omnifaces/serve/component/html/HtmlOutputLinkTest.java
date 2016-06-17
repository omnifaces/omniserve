/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlOutputLink.
 */
public class HtmlOutputLinkTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlOutputLink outputLink = new HtmlOutputLink();
        assertEquals("org.omnifaces.serve.component.html", outputLink.getFamily());
    }
}
