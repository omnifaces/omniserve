/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

/**
 * A response writer.
 */
public interface ResponseWriter {

    /**
     * Close the document.
     */
    void close();

    /**
     * End the document.
     *
     * @return the response writer.
     */
    ResponseWriter endDocument();

    /**
     * End the element.
     *
     * @param elementName the element name.
     * @return the response writer.
     */
    ResponseWriter endElement(String elementName);

    /**
     * Start the document.
     *
     * @return the response writer.
     */
    ResponseWriter startDocument();

    /**
     * Start the element.
     *
     * @param elementName the element name.
     * @return the response writer.
     */
    ResponseWriter startElement(String elementName);

    /**
     * Write the string.
     *
     * @param string the string.
     * @return the response writer.
     */
    ResponseWriter write(String string);

    /**
     * Write the attribute.
     *
     * @param name the name.
     * @param value the value.
     * @return the response writer.
     */
    ResponseWriter writeAttribute(String name, String value);

    /**
     * Write the text.
     *
     * @param string the string.
     * @return the response writer.
     */
    ResponseWriter writeText(String string);

    /**
     * Write the URI attribute.
     *
     * @param name the name.
     * @param value the value.
     * @return the response writer.
     */
    ResponseWriter writeURIAttribute(String name, String value);
}
