/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.c;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for c:forEach.
 *
 * 
 */
public class ForEachIT {

    /**
     * Test /c/forEach1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testForEach1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/c/forEach1.xhtml");
            assertTrue(page.asXml().contains("We are repeating!"));
            String pageXml = page.asXml().replaceFirst("We are repeating!", "REPLACED");
            assertTrue(pageXml.contains("We are repeating!"));
        }
    }
}
