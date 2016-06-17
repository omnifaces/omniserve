/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.h;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for h:body.
 *
 * 
 */
public class BodyIT {

    /**
     * Test /h/body1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testBody1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/h/body1.xhtml");
            assertTrue(page.asXml().contains("id=\"body\""));
        }
    }
}
