/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for f:validator.
 *
 * 
 */
public class ValidatorIT {

    /**
     * Test /f/validator1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidator1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validator1.xhtml");
            HtmlInput input = page.getHtmlElementById("inputText");
            input.type("1234");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertTrue(page.asXml().contains("Duke"));
        }
    }

    /**
     * Test /f/validator2.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidator2Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validator2.xhtml");
            HtmlInput input = page.getHtmlElementById("inputText");
            input.type("1234");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertFalse(page.asXml().contains("Duke"));
        }
    }

    /**
     * Test /f/validator2b.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidator2bXhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validator2b.xhtml");
            HtmlInput input = page.getHtmlElementById("inputText");
            input.type("1234");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertTrue(page.asXml().contains("Duke"));
        }
    }
}
