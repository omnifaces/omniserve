/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for f:validateRequired.
 *
 * 
 */
public class ValidateRequiredIT {

    /**
     * Test /f/validateRequired1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidateRequired1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validateRequired1.xhtml");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertTrue(page.asXml().contains("Value is required"));
        }
    }

    /**
     * Test /f/validateRequired2.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidateRequired2Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validateRequired2.xhtml");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertFalse(page.asXml().contains("Value is required"));
        }
    }
}
