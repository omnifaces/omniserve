/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.cc;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for cc:implementation.
 *
 * 
 */
public class ImplementationIT {

    /**
     * Test /cc/implementation1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testChoose1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/cc/implementation1.xhtml");
            assertTrue(page.asXml().contains("This is coming from a composite component."));
        }
    }
}
