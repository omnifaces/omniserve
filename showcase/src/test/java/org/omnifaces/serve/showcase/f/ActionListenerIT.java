/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for f:actionListener.
 *
 * 
 */
public class ActionListenerIT {

    /**
     * Test /f/actionListener1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidator1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/actionListener1.xhtml");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertTrue(page.asXml().contains("And I did it!"));
        }
    }
}
