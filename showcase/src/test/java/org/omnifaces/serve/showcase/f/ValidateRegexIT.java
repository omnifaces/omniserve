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
 * Integration tests for f:validateRegex.
 *
 * 
 */
public class ValidateRegexIT {

    /**
     * Test /f/validateRegex1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidateRegex1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validateRegex1.xhtml");
            HtmlInput input = page.getHtmlElementById("inputText");
            input.type("123456");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertTrue(page.asXml().contains("Unable to match pattern"));
        }
    }

    /**
     * Test /f/validateRegex2.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidateRegex2Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validateRegex2.xhtml");
            HtmlInput input = page.getHtmlElementById("inputText");
            input.type("123456");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertFalse(page.asXml().contains("Unable to match pattern"));
        }
    }
}
