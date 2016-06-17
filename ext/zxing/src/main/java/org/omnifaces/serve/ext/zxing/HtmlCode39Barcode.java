/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.zxing;

import org.omnifaces.serve.component.ServeComponent;
import org.omnifaces.serve.component.UIOutput;

/**
 * The component for zxing:code39Barcode.
 */
@ServeComponent(value = "org.omnifaces.serve.ext.zxing.HtmlCode39Barcode")
public class HtmlCode39Barcode extends UIOutput {

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        return "org.omnifaces.serve.ext.zxing";
    }
}
