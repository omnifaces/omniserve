/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.fn;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for fn:replace.
 *
 * 
 */
public class ReplaceIT {

    /**
     * Test /fn/replace1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testIndexOf1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/fn/replace1.xhtml");
            assertTrue(page.asXml().contains("This should be false"));
        }
    }
}
