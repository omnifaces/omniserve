/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.passthrough;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.serve.ext.processor.h.BodyProcessor;
import org.omnifaces.serve.ext.processor.h.ButtonProcessor;
import org.omnifaces.serve.ext.processor.h.CommandButtonProcessor;
import org.omnifaces.serve.ext.processor.h.CommandLinkProcessor;
import org.omnifaces.serve.ext.processor.h.FormProcessor;
import org.omnifaces.serve.ext.processor.h.GraphicImageProcessor;
import org.omnifaces.serve.ext.processor.h.HeadProcessor;
import org.omnifaces.serve.ext.processor.h.InputFileProcessor;
import org.omnifaces.serve.ext.processor.h.InputHiddenProcessor;
import org.omnifaces.serve.ext.processor.h.InputSecretProcessor;
import org.omnifaces.serve.ext.processor.h.InputTextProcessor;
import org.omnifaces.serve.ext.processor.h.InputTextareaProcessor;
import org.omnifaces.serve.ext.processor.h.LinkProcessor;
import org.omnifaces.serve.ext.processor.h.OutputLabelProcessor;
import org.omnifaces.serve.ext.processor.h.OutputLinkProcessor;
import org.omnifaces.serve.ext.processor.h.OutputScriptProcessor;
import org.omnifaces.serve.ext.processor.h.OutputStylesheetProcessor;
import org.omnifaces.template.Processor;
import org.omnifaces.template.TagAttribute;

/**
 * The pass-trough processor.
 */
public class PassthroughProcessor extends ServeTagProcessor {

    /**
     * Stores the element name.
     */
    private final String elementName;

    /**
     * Constructor.
     *
     * @param elementName the element name.
     */
    public PassthroughProcessor(String elementName) {
        this.elementName = elementName;
    }

    /**
     * Execute the processor.
     *
     * @param context the context.
     * @param parent the UI parent component.
     * @param index the index.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void process(ServeProcessorContext context, UIComponent parent, int index) {
        ServeTagProcessor processor = null;

        switch (elementName) {
            case "a":
                processor = getProcessorForA();
                break;
            case "body":
                processor = new BodyProcessor();
                break;
            case "button":
                processor = getProcessorForButton();
                break;
            case "form":
                processor = new FormProcessor();
                break;
            case "head":
                processor = new HeadProcessor();
                break;
            case "img":
                processor = new GraphicImageProcessor();
                break;
            case "input":
                processor = getProcessorForInput();
                break;
            case "label":
                processor = new OutputLabelProcessor();
                break;
            case "link":
                processor = new OutputStylesheetProcessor();
                break;
            case "script":
                processor = new OutputScriptProcessor();
                break;
            case "textarea":
                processor = new InputTextareaProcessor();
                break;
            default:
                break;
        }

        if (processor != null) {
            processor.setAttributes(convertAttributes(attributes));
            processor.setParent(getParent());
            for (Processor child : getChildren()) {
                child.setParent(processor);
                processor.getChildren().add(child);
            }
            processor.process(context, parent, index);
        } else {
            throw new RuntimeException("Unable to match passthrough element to processor");
        }
    }

    /**
     * Convert jsf: attributes.
     *
     * @param attributes the attribute map.
     * @return the converted attribute map.
     */
    protected Map<String, TagAttribute> convertAttributes(Map<String, TagAttribute> attributes) {
        ConcurrentHashMap<String, TagAttribute> result = new ConcurrentHashMap<>();

        attributes.values().stream().forEach((attribute) -> {
            if (attribute.getUri().equals("http://www.omnifaces.org/serve")) {
                result.put(attribute.getLocalName(), new TagAttribute(
                        "",
                        attribute.getLocalName(), attribute.getValue()));
            } else {
                result.put(attribute.getLocalName(), new TagAttribute(
                        "http://www.omnifaces.org/serve/passthrough",
                        attribute.getLocalName(), attribute.getValue()));
            }
        });

        return result;
    }

    /**
     * Get the processor for an "a".
     *
     * @return the processor.
     */
    private ServeTagProcessor getProcessorForA() {
        ServeTagProcessor result = null;

        for (Map.Entry<String, TagAttribute> attributeEntry : attributes.entrySet()) {
            TagAttribute attribute = attributeEntry.getValue();

            if (attribute.getUri().equals("http://www.omnifaces.org/serve")) {
                switch (attribute.getLocalName()) {
                    case "action":
                    case "actionListener":
                        result = new CommandLinkProcessor();
                        break;
                    case "value":
                        result = new OutputLinkProcessor();
                        break;
                    case "outcome":
                        result = new LinkProcessor();
                        break;
                    default:
                        break;
                }
            }

            if (result != null) {
                break;
            }
        }

        if (result == null) {
            throw new RuntimeException("Unable to match 'a' to the proper tag");
        }
        return result;
    }

    /**
     * Get the processor for "button".
     *
     * @return the processor.
     */
    private ServeTagProcessor getProcessorForButton() {
        ServeTagProcessor result = new CommandButtonProcessor();

        for (Map.Entry<String, TagAttribute> attributeEntry : attributes.entrySet()) {
            TagAttribute attribute = attributeEntry.getValue();

            if (attribute.getUri().equals("http://www.omnifaces.org/serve")) {
                switch (attribute.getLocalName()) {
                    case "outcome":
                        result = new ButtonProcessor();
                        break;
                    default:
                        break;
                }
            }
        }

        return result;
    }

    /**
     * Get the processor for "input".
     *
     * @return the processor.
     */
    private ServeTagProcessor getProcessorForInput() {
        ServeTagProcessor result = new InputTextProcessor();

        for (Map.Entry<String, TagAttribute> attributeEntry : attributes.entrySet()) {
            TagAttribute attribute = attributeEntry.getValue();

            if (attribute.getUri().equals("http://www.omnifaces.org/serve")
                    && attribute.getLocalName().equalsIgnoreCase("type")) {
                switch (attribute.getValue()) {
                    case "button":
                    case "submit":
                    case "reset":
                        result = new CommandButtonProcessor();
                        break;
                    case "file":
                        result = new InputFileProcessor();
                        break;
                    case "hidden":
                        result = new InputHiddenProcessor();
                        break;
                    case "password":
                        result = new InputSecretProcessor();
                        break;
                    default:
                        break;
                }
            }
        }

        return result;
    }
}
