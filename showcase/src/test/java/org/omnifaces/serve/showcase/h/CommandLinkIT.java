/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.h;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for h:commandLink.
 *
 * 
 */
public class CommandLinkIT {

    /**
     * Test /h/commandLink1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValidator1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setThrowExceptionOnScriptError(true);
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/h/commandLink1.xhtml");
            HtmlInput input = page.getHtmlElementById("inputText");
            input.type("1234");
            HtmlAnchor anchor = page.getHtmlElementById("commandLink");
            page = anchor.click();
            assertTrue(page.asXml().contains("And we replaced it"));
        }
    }
}
