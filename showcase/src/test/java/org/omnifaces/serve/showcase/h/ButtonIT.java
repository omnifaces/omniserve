/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.h;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for h:button.
 *
 * 
 */
public class ButtonIT {

    /**
     * Test /h/button1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testButton1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/h/button1.xhtml");
            assertTrue(page.asXml().contains("Also back to the main page"));
            HtmlButtonInput button = page.getHtmlElementById("button");
            page = button.click();
            assertTrue(page.asXml().contains("Welcome"));
        }
    }
}
