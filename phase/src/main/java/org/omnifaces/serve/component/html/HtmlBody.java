/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import org.omnifaces.serve.component.ServeComponent;
import org.omnifaces.serve.component.UIComponentBase;

/**
 * A HTML body.
 */
@ServeComponent(value = "org.omnifaces.serve.component.html.HtmlBody")
public class HtmlBody extends UIComponentBase {

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
