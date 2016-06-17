/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;
import org.omnifaces.serve.ext.processor.ServeDefaultHandler2;
import org.omnifaces.template.CompositeProcessor;
import org.omnifaces.template.Processor;
import org.omnifaces.template.ProcessorContext;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * A decorator around the ServeDefaultHandler for composite component support.
 */
@Decorator
@Priority(1000)
public abstract class ServeDefaultHandler2Decorator extends ServeDefaultHandler2 {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Stores the delegate.
     */
    @Inject
    @Delegate
    @Default
    private ServeDefaultHandler2 serveDefaultHandler2;

    /**
     * Process the characters.
     *
     * @param characters the characters.
     * @param start the start.
     * @param length the length.
     * @throws SAXException when a SAX error occurs.
     */
    @Override
    public void characters(char[] characters, int start, int length) throws SAXException {
        serveDefaultHandler2.characters(characters, start, length);
    }

    /**
     * End the document.
     *
     * @throws SAXException when a SAX error occurs.
     */
    @Override
    public void endDocument() throws SAXException {
        serveDefaultHandler2.endDocument();
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
        if (uri.startsWith("http://www.omnifaces.org/serve/ext/cc/")) {
            serveDefaultHandler2.pop();
        } else {
            serveDefaultHandler2.endElement(uri, localName, qName);
        }
    }

    /**
     * Start the document.
     *
     * @throws SAXException when a SAX error occurs.
     */
    @Override
    public void startDocument() throws SAXException {
        serveDefaultHandler2.startDocument();
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
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (uri.startsWith("http://www.omnifaces.org/serve/ext/cc/")) {
            CompositeProcessor<ProcessorContext, Object> parent;
            if (serveDefaultHandler2.peek() instanceof CompositeProcessor) {
                parent = (CompositeProcessor) serveDefaultHandler2.peek();
            } else {
                parent = (CompositeProcessor) serveDefaultHandler2.peek().getParent();
            }
            CompositeComponentProcessor compositeComponentProcessor
                    = cdiManager.getInstance(CompositeComponentProcessor.class);
            compositeComponentProcessor.setUri(uri);
            compositeComponentProcessor.setLocalName(localName);
            compositeComponentProcessor.setAttributes(getTagAttributes(attributes));
            compositeComponentProcessor.setParent((Processor) parent);
            serveDefaultHandler2.push((Processor) compositeComponentProcessor);
            parent.getChildren().add((Processor) compositeComponentProcessor);

        } else {
            serveDefaultHandler2.startElement(uri, localName, qName, attributes);
        }
    }
}
