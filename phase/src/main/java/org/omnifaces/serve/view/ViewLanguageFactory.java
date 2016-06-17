/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.view;

/**
 * The view language factory.
 */
public interface ViewLanguageFactory {

    /**
     * Get the view language.
     *
     * @param viewId the view id.
     * @return the view language.
     */
    ViewLanguage getViewLanguage(String viewId);
}
