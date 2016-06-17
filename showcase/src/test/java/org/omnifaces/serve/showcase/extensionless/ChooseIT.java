/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.extensionless;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for c:choose (in extensionless mode).
 *
 * 
 */
public class ChooseIT {

    /**
     * Test /c/choose1.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testChoose1() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/c/choose1");
            assertFalse(page.asXml().contains("This will be ignored."));
            assertTrue(page.asXml().contains("This will show!"));
        }
    }

    /**
     * Test /c/choose2.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testChoose2() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/c/choose2");
            assertFalse(page.asXml().contains("This will be ignored."));
            assertTrue(page.asXml().contains("This will be shown :)"));
        }
    }
}
