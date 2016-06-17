/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlMessages.
 */
public class HtmlMessagesTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlMessages messages = new HtmlMessages();
        assertEquals("org.omnifaces.serve.component.html", messages.getFamily());
    }
}
