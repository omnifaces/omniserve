/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.zxing;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Integration tests for zxing:codabarBarcode.
 *
 * 
 */
public class CodabarBarcodeIT {

    /**
     * Test /zxing/codabarBarcode1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testCode128Barcode1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/phase/zxing/codabarBarcode1.xhtml");
            assertTrue(page.asXml().contains("/showcase?org.omnifaces.serve.ext.zxing.ZXingFilter.writerName=HtmlCodabarBarcode&amp;height=100&amp;width=100&amp;value=0012345678905"));
        }
    }
}
