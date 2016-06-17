/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component.html;

import org.omnifaces.serve.component.ServeComponent;
import org.omnifaces.serve.component.UIOutput;

/**
 * An HTML script.
 */
@ServeComponent(value = "org.omnifaces.serve.component.html.HtmlOutputScript")
public class HtmlOutputScript extends UIOutput {

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
