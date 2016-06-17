/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import java.util.List;
import java.util.Map;
import javax.el.ValueExpression;

/**
 * An UI component.
 */
public interface UIComponent {

    /**
     * Get the attributes.
     *
     * @return the attributes.
     */
    Map<String, Object> getAttributes();

    /**
     * Get the list of children.
     *
     * @return the children.
     */
    List<UIComponent> getChildren();

    /**
     * Get the facet.
     *
     * @param facetName the facet name.
     * @return the facet.
     */
    UIComponent getFacet(String facetName);

    /**
     * Get the facets.
     *
     * @return the facets.
     */
    Map<String, UIComponent> getFacets();

    /**
     * Get the component family.
     *
     * @return the component family.
     */
    String getFamily();

    /**
     * Get the parent component.
     *
     * @return the parent component.
     */
    UIComponent getParent();

    /**
     * Get the pass-through attributes.
     *
     * @return the pass-through attributes.
     */
    Map getPassThroughAttributes();

    /**
     * Get the renderer type.
     *
     * @return the renderer type.
     */
    String getRendererType();

    /**
     * Get the value expression.
     *
     * @param attributeName the attribute name.
     * @return the value expression, or null if not found.
     */
    ValueExpression getValueExpression(String attributeName);

    /**
     * Set the parent UI component.
     *
     * @param parent the parent UI component.
     */
    void setParent(UIComponent parent);

    /**
     * Set the renderer type.
     *
     * @param rendererType the renderer type.
     */
    void setRendererType(String rendererType);

    /**
     * Set the value expression.
     *
     * @param attributeName the attribute name.
     * @param valueExpression the value expression.
     */
    void setValueExpression(String attributeName, ValueExpression valueExpression);
}
