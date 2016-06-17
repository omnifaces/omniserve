/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.h;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for h:doctype.
 *
 * 
 */
public class DoctypeIT {

    /**
     * Test /h/doctype1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testDoctype1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/h/doctype1.xhtml");
            assertTrue(page.getWebResponse().getContentAsString().contains("-//W3C//DTD XHTML 1.0 Transitional//EN"));
        }
    }
}
