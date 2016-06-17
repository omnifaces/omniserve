/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 * The default component factory.
 */
import org.omnifaces.serve.cdi.CdiManager;

@ApplicationScoped
@Default
public class DefaultComponentFactory implements ComponentFactory {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Create the component.
     *
     * @param componentType the component type.
     * @return the UI component.
     */
    @Override
    public UIComponent createComponent(String componentType) {
        return cdiManager.getInstance(UIComponent.class,
                new ServeComponentLiteral(componentType));
    }
}
