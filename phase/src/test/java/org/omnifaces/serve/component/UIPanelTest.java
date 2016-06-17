/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The JUnit tests for UIPanel.
 */
public class UIPanelTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        UIPanel panel = new UIPanel();
        assertEquals("org.omnifaces.serve.component", panel.getFamily());
    }
}
