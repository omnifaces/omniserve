/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * An integration test targeting the index page.
 *
 * 
 */
public class IndexPageIT {

    /**
     * Test /index.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testIndexXhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase");
            assertTrue(page.asXml().contains("Welcome"));
        }
    }

    /**
     * Test /index.filter.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testIndexFilter() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/index.filter");
            assertTrue(page.asXml().contains("Welcome"));
        }
    }
}
