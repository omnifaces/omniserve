/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.ui;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for ui:repeat.
 *
 * 
 */
public class RepeatIT {

    /**
     * Test /ui/repeat1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testRepeat1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/ui/repeat1.xhtml");
            assertTrue(page.asXml().contains("1"));
            assertTrue(page.asXml().contains("2"));
            assertTrue(page.asXml().contains("3"));
            assertTrue(page.asXml().contains("4"));
            assertTrue(page.asXml().contains("5"));
        }
    }
}
