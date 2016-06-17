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
 * The cc:interface XmlDefaultHandler.
 */
@Dependent
@Alternative
public class DefaultInterfaceHandler2 extends ServeDefaultHandler2 {

    /**
     * Stores the boolean flag to signal we have entered a cc:interface.
     */
    private boolean inInterface = false;

    @Override
    public void characters(char[] characters, int start, int length) throws SAXException {
        if (isInInterface()) {
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
        if (isInInterface()) {
            super.endElement(uri, localName, qName);
        }

        if (localName.equals("interface") && uri.equals("http://www.omnifaces.org/serve/ext/cc")) {
            setInInterface(false);
        }
    }

    /**
     * Get in-interface flag.
     *
     * @return the in-interface flag.
     */
    public boolean isInInterface() {
        return inInterface;
    }

    /**
     * Set the in-interface flag.
     *
     * @param inInterface the in-interface flag.
     */
    public void setInInterface(boolean inInterface) {
        this.inInterface = inInterface;
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

        if (localName.equals("interface") && uri.equals("http://www.omnifaces.org/serve/ext/cc")) {
            setInInterface(true);
        }

        if (isInInterface()) {
            super.startElement(uri, localName, qName, attributes);
        }
    }
}
