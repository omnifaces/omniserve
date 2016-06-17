/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlDataTable.
 */
public class HtmlDataTableTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlDataTable dataTable = new HtmlDataTable();
        assertEquals("org.omnifaces.serve.component.html", dataTable.getFamily());
    }
}
