/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlDoctype.
 */
public class HtmlDoctypeTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlDoctype commandLink = new HtmlDoctype();
        assertEquals("org.omnifaces.serve.component.html", commandLink.getFamily());
    }
}
