/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.zxing;

import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ResponseWriter;

/**
 * An abstract base class for bar-code renderers.
 */
public class HtmlBarcodeRenderer implements Renderer<PhaseContext, UIComponent> {

    /**
     * Write the barcode.
     *
     * @param context the context.
     * @param component the UI component.
     * @param src the img src attribute.
     */
    protected void writeBarcode(PhaseContext context, UIComponent component, StringBuilder src) {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("img");
        writer.writeURIAttribute("src", src.toString());
        writer.endElement("img");
    }
}
