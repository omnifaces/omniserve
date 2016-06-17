/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.view;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;

/**
 * The default view language factory.
 */
@ApplicationScoped
@Default
public class DefaultViewLanguageFactory implements ViewLanguageFactory {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Get the view language.
     *
     * @param viewId the view id.
     * @return the view language.
     */
    @Override
    public ViewLanguage getViewLanguage(String viewId) {
        return cdiManager.getInstance(ViewLanguage.class);
    }
}
