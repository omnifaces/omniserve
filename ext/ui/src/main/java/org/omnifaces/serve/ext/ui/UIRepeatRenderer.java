/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.ui;

import java.util.Iterator;
import java.util.List;
import javax.el.ValueExpression;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.phase.PhaseContext;
import org.omnifaces.serve.renderkit.Renderer;
import org.omnifaces.serve.renderkit.ServeRenderer;

/**
 * The renderer for ui:repeat.
 */
@ServeRenderer(renderKitId = "HTML_BASIC",
        componentFamily = "org.omnifaces.serve.ext.ui",
        rendererType = "org.omnifaces.serve.ext.ui.UIRepeat")
public class UIRepeatRenderer extends BaseRenderer {

    /**
     * Stores the HTTP servlet request.
     */
    @Inject
    private HttpServletRequest request;

    /**
     * Decode the component.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void decode(PhaseContext context, UIComponent component) {
        UIRepeat repeat = (UIRepeat) component;
        ValueExpression valueExpression = repeat.getValueExpression("value");
        List<Object> values = repeat.toList(valueExpression.getValue(context.getELContext()));
        String var = (String) getAttribute(context, component, "var");
        String varStatus = (String) getAttribute(context, component, "varStatus");
        int index = 0;
        if (values != null) {
            for (Object value : values) {
                request.setAttribute(var, value);
                UIRepeatVarStatus varStatusValue = new UIRepeatVarStatus();
                varStatusValue.setIndex(index);
                if (varStatus != null) {
                    request.setAttribute(varStatus, varStatusValue);
                }
                Iterator<UIComponent> children = repeat.getChildren().iterator();
                while (children.hasNext()) {
                    UIComponent child = children.next();
                    Renderer renderer = context.getRenderKit().getRenderer(child.getFamily(), child.getRendererType());
                    renderer.decode(context, child);
                }
                request.removeAttribute(var);
                if (varStatus != null) {
                    request.removeAttribute(varStatus);
                }
                index++;
            }
        }
    }

    /**
     * Encode the component.
     *
     * @param context the context.
     * @param component the UI component.
     */
    @Override
    public void encode(PhaseContext context, UIComponent component) {
        UIRepeat repeat = (UIRepeat) component;
        ValueExpression valueExpression = repeat.getValueExpression("value");
        List<Object> values = repeat.toList(valueExpression.getValue(context.getELContext()));
        String var = (String) getAttribute(context, component, "var");
        String varStatus = (String) getAttribute(context, component, "varStatus");
        int index = 0;
        if (values != null) {
            for (Object value : values) {
                request.setAttribute(var, value);
                if (varStatus != null) {
                    UIRepeatVarStatus varStatusValue = new UIRepeatVarStatus();
                    varStatusValue.setIndex(index);
                    request.setAttribute(varStatus, varStatusValue);
                }
                Iterator<UIComponent> children = repeat.getChildren().iterator();
                while (children.hasNext()) {
                    UIComponent child = children.next();
                    Renderer renderer = context.getRenderKit().getRenderer(child.getFamily(), child.getRendererType());
                    renderer.encode(context, child);
                }
                request.removeAttribute(var);
                if (varStatus != null) {
                    request.removeAttribute(varStatus);
                }
                index++;
            }
        }
    }
}
