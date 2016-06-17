/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlHead.
 */
public class HtmlHeadTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlHead head = new HtmlHead();
        assertEquals("org.omnifaces.serve.component.html", head.getFamily());
    }
}
