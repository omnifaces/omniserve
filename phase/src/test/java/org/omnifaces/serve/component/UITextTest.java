/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for UIText.
 */
public class UITextTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        UIText staticText = new UIText();
        assertEquals("org.omnifaces.serve.component", staticText.getFamily());
    }

    /**
     * Test getText method.
     */
    @Test
    public void testGetText() {
        UIText staticText = new UIText();
        staticText.setText("myText");
        assertEquals("myText", staticText.getText());
    }
}
