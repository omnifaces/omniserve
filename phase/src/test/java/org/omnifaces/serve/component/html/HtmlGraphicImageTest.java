/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlGraphicImage.
 */
public class HtmlGraphicImageTest {

    /**
     * Test getFamily method.
     */
    @Test
    public void testGetFamily() {
        HtmlGraphicImage graphicImage = new HtmlGraphicImage();
        assertEquals("org.omnifaces.serve.component.html", graphicImage.getFamily());
    }
}
