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
 * Integration tests for c:if.
 *
 * 
 */
public class IfIT {

    /**
     * Test /c/if1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testIf1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/c/if1.xhtml");
            assertFalse(page.asXml().contains("This will be ignored."));
        }
    }
    /**
     * Test /c/if2.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testIf2Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/c/if2.xhtml");
            assertTrue(page.asXml().contains("This will be shown."));
        }
    }
}
