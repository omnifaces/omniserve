/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for f:attributes.
 *
 * 
 */
public class AttributesIT {

    /**
     * Test /f/attributes1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testAttributes1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/f/attributes1.xhtml");
            assertTrue(page.asXml().contains("this is the value from the map"));
        }
    }
}
