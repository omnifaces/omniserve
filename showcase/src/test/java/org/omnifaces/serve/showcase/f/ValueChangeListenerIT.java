/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for f:valueChangeListener.
 *
 * 
 */
public class ValueChangeListenerIT {

    /**
     * Test /f/valueChangeListener1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testValueChangeListener1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/valueChangeListener1.xhtml");
            HtmlSubmitInput submit = page.getHtmlElementById("commandButton");
            page = submit.click();
            assertTrue(page.asXml().contains("f:valueChangeListener showcase #1"));
        }
    }
}
