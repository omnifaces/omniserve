/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.json;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import java.net.URL;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for JSON RenderKit.
 *
 * 
 */
public class JsonIT {

    /**
     * Test /json/outputText1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testOutputText1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            WebRequest request = new WebRequest(new URL("http://localhost:8080/showcase/json/outputText1.xhtml"));
            ArrayList<NameValuePair> requestParameters = new ArrayList<>();
            requestParameters.add(new NameValuePair("org.omnifaces.serve.RenderKitId", "JSON"));
            requestParameters.add(new NameValuePair("org.omnifaces.serve.ResponseContentType", "application/json"));
            request.setRequestParameters(requestParameters);
            Page page = (Page) webClient.getPage(request);
            assertTrue(page.getWebResponse().getContentAsString().contains("component"));
            assertTrue(page.getWebResponse().getContentAsString().contains("org.omnifaces.serve.component.html.HtmlOutputText"));
            assertTrue(page.getWebResponse().getContentType().equals("application/json"));
        }
    }
}