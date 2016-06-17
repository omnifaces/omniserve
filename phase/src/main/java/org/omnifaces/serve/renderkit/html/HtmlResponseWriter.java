/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit.html;

import java.io.IOException;
import java.io.Writer;
import org.omnifaces.serve.renderkit.ResponseWriter;

/**
 * The HTML response writer.
 */
public class HtmlResponseWriter implements ResponseWriter {

    /**
     * Stores if we are starting an element.
     */
    private boolean inStart;

    /**
     * Stores the writer.
     */
    private final Writer writer;

    /**
     * Constructor.
     *
     * @param writer the writer.
     */
    public HtmlResponseWriter(Writer writer) {
        this.writer = writer;
    }

    /**
     * Close the response writer.
     */
    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    /**
     * End the document.
     */
    @Override
    public ResponseWriter endDocument() {
        return this;
    }

    /**
     * Write the end of the element.
     *
     * @param elementName the element name.
     */
    @Override
    public ResponseWriter endElement(String elementName) {
        try {
            writeEndStartElement();
            writer.write("</");
            writer.write(elementName);
            writer.write(">");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return this;
    }

    /**
     * Start the document.
     */
    @Override
    public ResponseWriter startDocument() {
        return this;
    }

    /**
     * Start the element.
     *
     * @param elementName the element name.
     */
    @Override
    public ResponseWriter startElement(String elementName) {
        try {
            writeEndStartElement();
            writer.write("<");
            writer.write(elementName);
            inStart = true;
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return this;
    }

    /**
     * Write the string.
     *
     * @param string the string.
     */
    @Override
    public ResponseWriter write(String string) {
        try {
            writeEndStartElement();
            writer.write(string);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return this;
    }

    /**
     * Write the attribute.
     *
     * @param name the name.
     * @param value the value.
     */
    @Override
    public ResponseWriter writeAttribute(String name, String value) {
        try {
            writer.write(" ");
            writer.write(name);
            writer.write("=\"");
            writer.write(value);
            writer.write("\"");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return this;
    }

    /**
     * Write the end of the start element.
     *
     * @throws IOException when an I/O error occurs.
     */
    private void writeEndStartElement() {
        try {
            if (inStart) {
                inStart = false;
                writer.write(">");
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    /**
     * Write the text.
     *
     * @param text the text.
     */
    @Override
    public ResponseWriter writeText(String text) {
        try {
            writeEndStartElement();
            writer.write(text);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return this;
    }

    /**
     * Write the URI attribute.
     *
     * @param name the name.
     * @param value the value.
     */
    @Override
    public ResponseWriter writeURIAttribute(String name, String value) {
        try {
            writer.write(" ");
            writer.write(name);
            writer.write("=\"");
            writer.write(value);
            writer.write("\"");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return this;
    }
}
