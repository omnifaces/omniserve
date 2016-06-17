/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlLink.
 */
public class HtmlLinkTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlLink link = new HtmlLink();
        assertEquals("org.omnifaces.serve.component.html", link.getFamily());
    }
}
