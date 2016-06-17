/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for f:passThroughAttributes.
 *
 * 
 */
public class PassThroughAttributesIT {

    /**
     * Test /f/passThroughAttributes1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testPassThroughAttributes1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/passThroughAttributes1.xhtml");
            assertTrue(page.asXml().contains("This should be blue!"));
        }
    }
}
