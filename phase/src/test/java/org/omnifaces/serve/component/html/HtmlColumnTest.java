/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlColumn.
 */
public class HtmlColumnTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlColumn column = new HtmlColumn();
        assertEquals("org.omnifaces.serve.component.html", column.getFamily());
    }
}
