/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

/**
 * The UI view root.
 */
@ServeComponent("org.omnifaces.serve.component.UIViewRoot")
public class UIViewRoot extends UIComponentBase {

    /**
     * Stores the view id.
     */
    private String viewId;

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        return "org.omnifaces.serve.component";
    }

    /**
     * Get the view id.
     *
     * @return the view id.
     */
    public String getViewId() {
        return viewId;
    }

    /**
     * Set the view id.
     *
     * @param viewId the view id.
     */
    public void setViewId(String viewId) {
        this.viewId = viewId;
    }
}
