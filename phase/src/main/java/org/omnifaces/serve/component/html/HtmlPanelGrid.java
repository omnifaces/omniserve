/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import org.omnifaces.serve.component.ServeComponent;
import org.omnifaces.serve.component.UIPanel;

/**
 * An HTML panel grid.
 */
@ServeComponent(value = "org.omnifaces.serve.component.html.HtmlPanelGrid")
public class HtmlPanelGrid extends UIPanel {

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        return "org.omnifaces.serve.component.html";
    }
}
