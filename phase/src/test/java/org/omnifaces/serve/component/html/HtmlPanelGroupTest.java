/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlPanelGroup.
 */
public class HtmlPanelGroupTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlPanelGroup panelGroup = new HtmlPanelGroup();
        assertEquals("org.omnifaces.serve.component.html", panelGroup.getFamily());
    }
}
