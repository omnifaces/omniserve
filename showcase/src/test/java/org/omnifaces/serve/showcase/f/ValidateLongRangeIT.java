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
 * Integration tests for f:validateLongRange.
 *
 * 
 */
public class ValidateLongRangeIT {

    /**
     * Test /f/validateLongRange1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidateLongRange1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validateLongRange1.xhtml");
            HtmlInput input = page.getHtmlElementById("inputText");
            input.type("12");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertTrue(page.asXml().contains("Value is more than expected maximum"));
            input = page.getHtmlElementById("inputText");
            input.type("0");
            submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertTrue(page.asXml().contains("Value is less than expected minimum"));
        }
    }

    /**
     * Test /f/validateLongRange2.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidateLongRange2Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validateLongRange2.xhtml");
            HtmlInput input = page.getHtmlElementById("inputText");
            input.type("12");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertFalse(page.asXml().contains("Value is more than expected maximum"));
            input = page.getHtmlElementById("inputText");
            input.type("0");
            submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertFalse(page.asXml().contains("Value is less than expected minimum"));
        }
    }
}
