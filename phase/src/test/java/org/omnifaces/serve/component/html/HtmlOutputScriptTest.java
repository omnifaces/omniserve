/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlOutputScript.
 */
public class HtmlOutputScriptTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlOutputScript outputScript = new HtmlOutputScript();
        assertEquals("org.omnifaces.serve.component.html", outputScript.getFamily());
    }
}
