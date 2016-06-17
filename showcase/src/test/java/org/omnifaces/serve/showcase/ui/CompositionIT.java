/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.ui;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for ui:composition.
 *
 * 
 */
public class CompositionIT {

    /**
     * Test /ui/composition1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testComposition1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/ui/composition1.xhtml");
            assertTrue(page.asXml().contains("left"));
            assertTrue(page.asXml().contains("right"));
            assertTrue(page.asXml().contains("content"));
        }
    }

    /**
     * Test /ui/composition2.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testComposition2Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/ui/composition2.xhtml");
            assertTrue(page.asXml().contains("left"));
            assertTrue(page.asXml().contains("content"));
            HtmlInput input = page.getHtmlElementById("inputText");
            input.type("1234");
            HtmlSubmitInput button = page.getHtmlElementById("commandButton");
            page = button.click();
            assertTrue(page.asXml().contains("1234"));
        }
    }
}
