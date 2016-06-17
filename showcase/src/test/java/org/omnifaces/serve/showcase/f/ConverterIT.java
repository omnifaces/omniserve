/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for f:converter.
 *
 * 
 */
public class ConverterIT {

    /**
     * Test /f/converter1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testConverter1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/converter1.xhtml");
            assertTrue(page.asXml().contains("org.omnifaces.serve.showcase.Converter1@"));
        }
    }

    /**
     * Test /f/converter2.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testConverter2Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/converter2.xhtml");
            assertTrue(page.asXml().contains("1234"));
        }
    }
}
