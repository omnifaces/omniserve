/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.zxing;

import javax.el.ValueExpression;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The renderer for zxing:ean13Barcode.
 */
@ServeRenderer(componentFamily = "org.omnifaces.serve.ext.zxing",
        rendererType = "org.omnifaces.serve.ext.zxing.HtmlEAN13Barcode")
public class HtmlEAN13BarcodeRenderer extends HtmlBarcodeRenderer {

    /**
     * Stores the HTTP servlet request.
     */
    @Inject
    private HttpServletRequest request;

    /**
     * Encode.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        HtmlEAN13Barcode barcode = (HtmlEAN13Barcode) component;
        String value = (String) ((ValueExpression) barcode.getValue()).getValue(context.getELContext());
        StringBuilder src = new StringBuilder();
        src.append(request.getContextPath());
        src.append("?org.omnifaces.serve.ext.zxing.ZXingFilter.writerName=HtmlEAN13Barcode&height=");
        src.append(barcode.getAttributes().getOrDefault("height", "100"));
        src.append("&width=");
        src.append(barcode.getAttributes().getOrDefault("width", "100"));
        src.append("&value=");
        src.append(value);
        writeBarcode(context, component, src);
    }
}
