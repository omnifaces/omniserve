/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.c;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for c:choose.
 *
 * 
 */
public class ChooseIT {

    /**
     * Test /c/choose1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testChoose1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/c/choose1.xhtml");
            assertFalse(page.asXml().contains("This will be ignored."));
            assertTrue(page.asXml().contains("This will show!"));
        }
    }

    /**
     * Test /c/choose2.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testChoose2Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/c/choose2.xhtml");
            assertFalse(page.asXml().contains("This will be ignored."));
            assertTrue(page.asXml().contains("This will be shown :)"));
        }
    }
}
