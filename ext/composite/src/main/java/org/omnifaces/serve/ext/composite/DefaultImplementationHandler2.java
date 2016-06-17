/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;
import org.omnifaces.serve.ext.processor.ServeDefaultHandler2;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * The cc:implementation XmlDefaultHandler.
 */
@Dependent
@Alternative
public class DefaultImplementationHandler2 extends ServeDefaultHandler2 {

    /**
     * Stores the boolean flag to signal we have entered a cc:implementation.
     */
    private boolean inImplementation = false;

    /**
     * Handle characters.
     *
     * @param characters the characters.
     * @param start the start.
     * @param length the length.
     * @throws SAXException when a SAX error occurs.
     */
    @Override
    public void characters(char[] characters, int start, int length) throws SAXException {
        if (isInImplementation()) {
            super.characters(characters, start, length);
        }
    }

    /**
     * End the element.
     *
     * @param uri the URI.
     * @param localName the local name.
     * @param qName the QName.
     * @throws SAXException when a SAX error occurs.
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isInImplementation()) {
            super.endElement(uri, localName, qName);
        }

        if (localName.equals("implementation") && uri.equals("http://www.omnifaces.org/serve/ext/cc")) {
            setInImplementation(false);
        }
    }

    /**
     * Is in-implementation.
     *
     * @return the in-implementation flag.
     */
    public boolean isInImplementation() {
        return inImplementation;
    }

    /**
     * Set in-implementation flag.
     *
     * @param inImplementation the in-implementation flag.
     */
    public void setInImplementation(boolean inImplementation) {
        this.inImplementation = inImplementation;
    }

    /**
     * Start the element.
     *
     * @param uri the URI.
     * @param localName the local name.
     * @param qName the QName.
     * @param attributes the attributes.
     * @throws SAXException when a SAX error occurs.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (localName.equals("implementation") && uri.equals("http://www.omnifaces.org/serve/ext/cc")) {
            setInImplementation(true);
        }

        if (isInImplementation()) {
            super.startElement(uri, localName, qName, attributes);
        }
    }
}
