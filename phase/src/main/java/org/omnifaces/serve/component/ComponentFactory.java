/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

/**
 * The API for a component factory.
 */
public interface ComponentFactory {

    /**
     * Create the component.
     *
     * @param componentType the component type.
     * @return the UI component.
     */
    UIComponent createComponent(String componentType);
}
