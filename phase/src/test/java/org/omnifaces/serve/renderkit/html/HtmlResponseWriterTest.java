/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The JUnit tests for HtmlResponseWriter.
 */
public class HtmlResponseWriterTest {

    /**
     * Test close method.
     */
    @Test
    public void testClose() {
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(new StringWriter());
        responseWriter.close();
    }

    /**
     * Test close method.
     */
    @Test(expected = RuntimeException.class)
    public void testClose2() {
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(new TestIOExceptionAlwaysWriter());
        responseWriter.close();
    }

    /**
     * Test endDocument method.
     */
    @Test
    public void testEndDocument() {
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(new StringWriter());
        responseWriter.endDocument();
    }

    /**
     * Test endElement method.
     */
    @Test
    public void testEndElement() {
        StringWriter stringWriter = new StringWriter();
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(stringWriter);
        responseWriter.endElement("html");
        assertEquals("</html>", stringWriter.toString());
    }

    /**
     * Test endElement method.
     */
    @Test(expected = RuntimeException.class)
    public void testEndElement2() {
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(new TestIOExceptionAlwaysWriter());
        responseWriter.endElement("html");
    }

    /**
     * Test startDocument method.
     */
    @Test
    public void testStartDocument() {
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(new StringWriter());
        responseWriter.startDocument();
    }

    /**
     * Test startElement method.
     */
    @Test
    public void testStartElement() {
        StringWriter stringWriter = new StringWriter();
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(stringWriter);
        responseWriter.startElement("html");
        assertEquals("<html", stringWriter.toString());
    }

    /**
     * Test startElement method.
     */
    @Test(expected = RuntimeException.class)
    public void testStartElement2() {
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(new TestIOExceptionAlwaysWriter());
        responseWriter.startElement("html");
    }

    /**
     * Test startElement method.
     */
    @Test
    public void testStartElement3() {
        StringWriter stringWriter = new StringWriter();
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(stringWriter);
        responseWriter.startElement("html");
        assertEquals("<html", stringWriter.toString());
        responseWriter.endElement("html");
        assertEquals("<html></html>", stringWriter.toString());
    }

    /**
     * Test startElement method.
     */
    @Test(expected = RuntimeException.class)
    public void testStartElement4() {
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(new TestIOExceptionCloseWriter());
        responseWriter.startElement("html");
        responseWriter.endElement("html");
    }

    /**
     * Test write method.
     */
    @Test
    public void testWrite() {
        StringWriter stringWriter = new StringWriter();
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(stringWriter);
        responseWriter.write("lalalala");
        assertEquals("lalalala", stringWriter.toString());
    }

    /**
     * Test write method.
     */
    @Test(expected = RuntimeException.class)
    public void testWrite2() {
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(new TestIOExceptionAlwaysWriter());
        responseWriter.write("lalalala");
    }

    /**
     * Test writeAttribute method.
     */
    @Test
    public void testWriteAttribute() {
        StringWriter stringWriter = new StringWriter();
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(stringWriter);
        responseWriter.writeAttribute("name", "value");
        assertEquals(" name=\"value\"", stringWriter.toString());
    }

    /**
     * Test writeAttribute method.
     */
    @Test(expected = RuntimeException.class)
    public void testWriteAttribute2() {
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(new TestIOExceptionAlwaysWriter());
        responseWriter.writeAttribute("name", "value");
    }

    /**
     * Test writeText method.
     */
    @Test
    public void testWriteText() {
        StringWriter stringWriter = new StringWriter();
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(stringWriter);
        responseWriter.writeText("text");
        assertEquals("text", stringWriter.toString());
    }

    /**
     * Test writeText method.
     */
    @Test(expected = RuntimeException.class)
    public void testWriteText2() {
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(new TestIOExceptionAlwaysWriter());
        responseWriter.writeText("text");
    }

    /**
     * Test writeURIAttribute method.
     */
    @Test
    public void testWriteURIAttribute() {
        StringWriter stringWriter = new StringWriter();
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(stringWriter);
        responseWriter.writeURIAttribute("name", "value");
        assertEquals(" name=\"value\"", stringWriter.toString());
    }

    /**
     * Test writeURIAttribute method.
     */
    @Test(expected = RuntimeException.class)
    public void testWriteURIAttribute2() {
        HtmlResponseWriter responseWriter = new HtmlResponseWriter(new TestIOExceptionAlwaysWriter());
        responseWriter.writeURIAttribute("name", "value");
    }

    /**
     * Helper class for testing.
     */
    public static class TestIOExceptionCloseWriter extends Writer {

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            if (cbuf[0] == '>') {
                throw new IOException();
            }
        }

        @Override
        public void flush() throws IOException {
        }

        @Override
        public void close() throws IOException {
        }
    }

    /**
     * Helper class for testing.
     */
    public static class TestIOExceptionAlwaysWriter extends Writer {

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            throw new IOException();
        }

        @Override
        public void flush() throws IOException {
            throw new IOException();
        }

        @Override
        public void close() throws IOException {
            throw new IOException();
        }
    }
}
