/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The JUnit tests for UIInclude.
 */
public class UIIncludeTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        UIInclude include = new UIInclude();
        assertEquals("org.omnifaces.serve.ext.ui", include.getFamily());
    }
}
