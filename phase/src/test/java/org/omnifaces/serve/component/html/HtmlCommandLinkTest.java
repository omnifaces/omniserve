/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlCommandLink.
 */
public class HtmlCommandLinkTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlCommandLink commandLink = new HtmlCommandLink();
        assertEquals("org.omnifaces.serve.component.html", commandLink.getFamily());
    }
}
