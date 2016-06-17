/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlBody.
 */
public class HtmlBodyTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlBody body = new HtmlBody();
        assertEquals("org.omnifaces.serve.component.html", body.getFamily());
    }
}
