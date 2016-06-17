/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for f:validateDoubleRange.
 *
 * 
 */
public class ValidateDoubleRangeIT {

    /**
     * Test /f/validateDoubleRange1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidateDoubleRange1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/validateDoubleRange1.xhtml");
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
}
