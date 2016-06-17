/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.passthrough;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for a pass-through.
 *
 * 
 */
public class AIT {

    /**
     * Test /passthrough/a1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidator1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/passthrough/a1.xhtml");
            assertTrue(page.asXml().contains("Also back to the main page"));
            assertTrue(page.asXml().contains("href=\"/showcase/index.xhtml"));
        }
    }
}
