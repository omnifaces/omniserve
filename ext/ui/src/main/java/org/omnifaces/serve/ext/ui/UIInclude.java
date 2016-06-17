/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import org.omnifaces.serve.component.ServeComponent;
import org.omnifaces.serve.component.UIPanel;

/**
 * The UI component for ui:include.
 */
@ServeComponent("org.omnifaces.serve.ext.ui.UIInclude")
public class UIInclude extends UIPanel {

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        return "org.omnifaces.serve.ext.ui";
    }
}
