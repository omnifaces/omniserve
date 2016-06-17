/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlPanelGrid.
 */
public class HtmlPanelGridTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlPanelGrid panelGrid = new HtmlPanelGrid();
        assertEquals("org.omnifaces.serve.component.html", panelGrid.getFamily());
    }
}
