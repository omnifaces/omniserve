/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.zxing;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for zxing:code39Barcode.
 *
 * 
 */
public class Code39BarcodeIT {

    /**
     * Test /zxing/code39Barcode1.xhtml.
     *
     * @throws Exception when an error occurs.
     */
    @Test
    public void testCode39Barcode1Xhtml() throws Exception {
        try (WebClient webClient = new WebClient()) {
            HtmlPage page = (HtmlPage) webClient.getPage("http://localhost:8080/showcase/zxing/code39Barcode1.xhtml");
            assertTrue(page.asXml().contains("/showcase?org.omnifaces.serve.ext.zxing.ZXingFilter.writerName=HtmlCode39Barcode&amp;height=100&amp;width=100&amp;value=0012345678905"));
        }
    }
}
