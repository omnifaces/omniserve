/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The JUnit tests for UIInsert.
 */
public class UIInsertTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        UIInsert insert = new UIInsert();
        assertEquals("org.omnifaces.serve.ext.ui", insert.getFamily());
    }
}
