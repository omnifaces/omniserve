/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.composite;

import java.util.Iterator;
import javax.enterprise.context.Dependent;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.ext.processor.ServeProcessorContext;
import org.omnifaces.serve.ext.processor.ServeTagProcessor;
import org.omnifaces.template.TagAttribute;

/**
 * The tag processor that deals with composite components.
 */
@Dependent
public class CompositeComponentProcessor extends ServeTagProcessor {

    /**
     * Stores the local name.
     */
    private String localName;

    /**
     * Stores the URI.
     */
    private String uri;

    /**
     * Set the local name.
     *
     * @param localName the local name.
     */
    public void setLocalName(String localName) {
        this.localName = localName;
    }

    /**
     * Set the URI.
     *
     * @param uri the URI.
     */
    public void setUri(String uri) {
        this.uri = uri;
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
        UICompositeComponent container;

        container = new UICompositeComponent();
        parent.getChildren().add(container);

        StringBuilder resourceLocation = new StringBuilder();
        resourceLocation.append("/resources/");

        if (uri.startsWith("http://www.omnifaces.org/serve/ext/cc/")) {
            resourceLocation.append(uri.substring("http://www.omnifaces.org/serve/ext/cc/".length()));
        }

        resourceLocation.append("/");
        resourceLocation.append(localName);
        resourceLocation.append(".xhtml");

        UIComponent compositeComponent;

        /*
         * Process the interface
         */
        UICompositeInterface interfaceHolder = new UICompositeInterface();
        DefaultInterfaceHandler2 interfaceHandler2 = new DefaultInterfaceHandler2();
        ServeTagProcessor interfaceProcessor = context.createProcessor(
                resourceLocation.toString(), interfaceHandler2);
        interfaceProcessor.process(context, interfaceHolder, 0);

        /*
             * Determine if we need to create an instance using the componentType
             * specified by the cc:interface.
         */
        if (interfaceHolder.getAttributes().containsKey("componentType")) {
            String className = (String) interfaceHolder.getAttributes().get("componentType");

            try {
                Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(className);
                Object object = clazz.newInstance();
                compositeComponent = (UIComponent) object;
            } catch (ClassNotFoundException cnfe) {
                throw new RuntimeException("Unable to load composite component class: " + className, cnfe);
            } catch (InstantiationException ie) {
                throw new RuntimeException("Unable to instantiate composite component for class: " + className, ie);
            } catch (IllegalAccessException iae) {
                throw new RuntimeException("Unable to access composite component class: " + className, iae);
            }
        } else {
            compositeComponent = context.createComponent("org.omnifaces.serve.ext.composite.UICompositeComponent");
        }

        container.getChildren().add(compositeComponent);

        processValueExpressionAttribute(context, compositeComponent, "id", String.class);

        /*
         * Support passing attributes into a composite component.
         */
        Iterator<TagAttribute> tagAttributes = attributes.values().iterator();
        while (tagAttributes.hasNext()) {
            TagAttribute tagAttribute = tagAttributes.next();
            if (!"id".equals(tagAttribute.getLocalName())) {
                processValueExpressionAttribute(context,
                        compositeComponent, tagAttribute.getLocalName(), Object.class);
            }
        }

        super.process(context, compositeComponent, 0);

        DefaultImplementationHandler2 implementationHandler2 = new DefaultImplementationHandler2();
        ServeTagProcessor processor = context.createProcessor(resourceLocation.toString(), implementationHandler2);
        processor.process(context, compositeComponent, 0);
    }
}
