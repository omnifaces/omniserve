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
 * Integration tests for f:validateLength.
 *
 * 
 */
public class ValidateLengthIT {

    /**
     * Test /f/validateDoubleRange1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidateLength1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validateLength1.xhtml");
            HtmlInput input = page.getHtmlElementById("inputText");
            input.type("123456");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertTrue(page.asXml().contains("Length is more than expected maximum"));
            input = page.getHtmlElementById("inputText");
            input.type("0");
            submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertTrue(page.asXml().contains("Length is less than expected minimum"));
        }
    }
    /**
     * Test /f/validateDoubleRange1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidateLength2Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validateLength2.xhtml");
            HtmlInput input = page.getHtmlElementById("inputText");
            input.type("123456");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertFalse(page.asXml().contains("Length is more than expected maximum"));
            input = page.getHtmlElementById("inputText");
            input.type("0");
            submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertFalse(page.asXml().contains("Length is less than expected minimum"));
        }
    }
}
