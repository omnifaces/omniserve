/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.jsf;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeTagProcessorFactory;
import org.omnifaces.template.ProcessorContext;
import org.omnifaces.template.TagProcessor;
import org.omnifaces.template.TagProcessorFactory;

/**
 * A decorator around the ServeTagProcessorFactory.
 *
 * <p>
 * This decorator rewrites any JSF name space into a OmniServe name space before
 * letting the TagProcessorFactory handle it.
 * </p>
 */
@Decorator
@Priority(1000)
public abstract class JsfTagProcessorFactoryDecorator implements TagProcessorFactory<ProcessorContext, UIComponent> {

    /**
     * Store the delegate.
     */
    @Inject
    @Delegate
    @Default
    private ServeTagProcessorFactory serveTagProcessoFactory;

    /**
     * Stores the map of URI aliases.
     */
    private final Map<String, String> uriAliases;

    /**
     * Constructor.
     */
    public JsfTagProcessorFactoryDecorator() {
        uriAliases = new HashMap<>();
        uriAliases.put("http://xmlns.jcp.org/jsf/html", "http://www.omnifaces.org/serve/ext/h");
        uriAliases.put("http://xmlns.jcp.org/jsf/core", "http://www.omnifaces.org/serve/ext/f");
        uriAliases.put("http://xmlns.jcp.org/jsp/jstl/core", "http://www.omnifaces.org/serve/ext/c");
        uriAliases.put("http://xmlns.jcp.org/jsf/composite", "http://www.omnifaces.org/serve/ext/cc");
        uriAliases.put("http://xmlns.jcp.org/jsf/facelets", "http://www.omnifaces.org/serve/ext/ui");
        uriAliases.put("http://java.sun.com/jsf/html", "http://www.omnifaces.org/serve/ext/h");
        uriAliases.put("http://java.sun.com/jsf/core", "http://www.omnifaces.org/serve/ext/f");
        uriAliases.put("http://java.sun.com/jsp/jstl/core", "http://www.omnifaces.org/serve/ext/c");
        uriAliases.put("http://java.sun.com/jsf/composite", "http://www.omnifaces.org/serve/ext/cc");
        uriAliases.put("http://java.sun.com/jsf/facelets", "http://www.omnifaces.org/serve/ext/ui");
    }

    /**
     * Get the tag processor.
     *
     * @param uri the URI.
     * @param localName the local name.
     * @return the tag processor.
     */
    @Override
    public TagProcessor getTagProcessor(String uri, String localName) {
        if (hasTagProcessor(uri, localName) && uriAliases.containsKey(uri)) {
            uri = getUri(uri, localName);
        }
        return serveTagProcessoFactory.getTagProcessor(uri, localName);
    }

    /**
     * Get the new namespace URI.
     *
     * @param uri the original namespace URI.
     * @param localName the local name.
     * @return the new namespace URI.
     */
    private String getUri(String uri, String localName) {
        if (uri.equals("http://xmlns.jcp.org/jsf/core")
                || uri.equals("http://java.sun.com/jsf/core")) {
            switch (localName) {
                case "convertDateTime":
                case "convertNumber":
                case "converter":
                    uri = "http://www.omnifaces.org/serve/ext/converter";
                    break;
                case "validateDoubleRange":
                case "validateLength":
                case "validateLongRange":
                case "validateRegex":
                case "validateRequired":
                case "validator":
                    uri = "http://www.omnifaces.org/serve/ext/validator";
                    break;
                default:
                    uri = uriAliases.get(uri);
                    break;
            }
        } else {
            uri = uriAliases.get(uri);
        }
        return uri;
    }

    /**
     * Has the tag processor.
     *
     * @param uri the URI.
     * @param localName the local name.
     * @return true if it has a tag processor, false otherwise.
     */
    @Override
    public boolean hasTagProcessor(String uri, String localName) {
        if (uriAliases.containsKey(uri)) {
            uri = getUri(uri, localName);
        }
        return serveTagProcessoFactory.hasTagProcessor(uri, localName);
    }
}
