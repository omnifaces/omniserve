/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.h;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for h:head.
 *
 * 
 */
public class HeadIT {

    /**
     * Test /phase/h/head1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testBody1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/phase/h/head1.xhtml");
            assertTrue(page.asXml().contains("<head"));
        }
    }
}
