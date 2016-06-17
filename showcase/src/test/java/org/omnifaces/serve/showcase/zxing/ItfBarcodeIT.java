/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.zxing;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for zxing:itfBarcode.
 *
 * 
 */
public class ItfBarcodeIT {

    /**
     * Test /zxing/itfBarcode1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testItfBarcode1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/zxing/itfBarcode1.xhtml");
            assertTrue(page.asXml().contains("/showcase?org.omnifaces.serve.ext.zxing.ZXingFilter.writerName=HtmlItfBarcode&amp;height=100&amp;width=100&amp;value=001234567890"));
        }
    }
}
