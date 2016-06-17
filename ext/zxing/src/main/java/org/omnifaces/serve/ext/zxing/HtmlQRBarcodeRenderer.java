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
 * The renderer for zxing:qrBarcode.
 */
@ServeRenderer(componentFamily = "org.omnifaces.serve.ext.zxing",
        rendererType = "org.omnifaces.serve.ext.zxing.HtmlQRBarcode")
public class HtmlQRBarcodeRenderer extends HtmlBarcodeRenderer {

    /**
     * Stores the HTTP servlet response.
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
        HtmlQRBarcode barcode = (HtmlQRBarcode) component;
        String value = (String) ((ValueExpression) barcode.getValue()).getValue(context.getELContext());
        StringBuilder src = new StringBuilder();
        src.append(request.getContextPath());
        src.append("?org.omnifaces.serve.ext.zxing.ZXingFilter.writerName=HtmlQRBarcode&height=");
        src.append(barcode.getAttributes().getOrDefault("height", "100"));
        src.append("&width=");
        src.append(barcode.getAttributes().getOrDefault("width", "100"));
        src.append("&value=");
        src.append(value);
        writeBarcode(context, component, src);
    }
}
