/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlMessage.
 */
public class HtmlMessageTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlMessage message = new HtmlMessage();
        assertEquals("org.omnifaces.serve.component.html", message.getFamily());
    }
}
