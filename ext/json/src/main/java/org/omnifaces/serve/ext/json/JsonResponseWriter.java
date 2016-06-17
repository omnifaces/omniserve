/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.json;

import java.io.IOException;
import java.io.Writer;
import org.omnifaces.serve.renderkit.ResponseWriter;

/**
 * The JSON response writer.
 */
public class JsonResponseWriter implements ResponseWriter {

    /**
     * Stores the writer.
     */
    private final Writer writer;

    /**
     * Constructor.
     *
     * @param writer the writer.
     */
    public JsonResponseWriter(Writer writer) {
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
        try {
            writer.write("}");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

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
            writer.write("}");
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
        try {
            writer.write("{");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

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
            writer.write("\"" + elementName + "\": {");
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
            writer.write("\"" + name + "\"");
            writer.write(": ");
            writer.write("\"" + escape(value) + "\"");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return this;
    }

    /**
     * Write the text.
     *
     * @param text the text.
     */
    @Override
    public ResponseWriter writeText(String text) {
        try {
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
            writer.write("\"" + name + "\"");
            writer.write(": ");
            writer.write("\"" + escape(value) + "\"");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return this;
    }

    /**
     * Escape the string.
     *
     * @param string the string.
     * @return the escaped string.
     */
    public String escape(String string) {
        String result = string;
        result = result.replace("\\", "\\\\");
        result = result.replace("\"", "\\\"");
        result = result.replace("/", "\\/");
        return result;
    }
}
