/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for f:passThroughAttribute.
 *
 * 
 */
public class PassThroughAttributeIT {

    /**
     * Test /f/passThroughAttribute1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testPassThroughAttribute1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/passThroughAttribute1.xhtml");
            assertTrue(page.asXml().contains("This should be blue!"));
        }
    }
}
