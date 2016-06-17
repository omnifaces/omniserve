/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.el.ValueExpression;

/**
 * A base implementation of UIComponent.
 */
public abstract class UIComponentBase implements UIComponent {

    /**
     * Stores the attributes.
     */
    protected final Map<String, Object> attributes;

    /**
     * Stores the children.
     */
    protected final List<UIComponent> children;

    /**
     * Stores the facets.
     */
    protected final Map<String, UIComponent> facets;

    /**
     * Stores the parent.
     */
    protected UIComponent parent;

    /**
     * Stores the pass through attributes.
     */
    protected Map<String, String> passThroughAttributes;

    /**
     * Stores the renderer type.
     */
    protected String rendererType;

    /**
     * Constructor.
     */
    public UIComponentBase() {
        attributes = new HashMap<>(2);
        children = new ArrayList<>(1);
        facets = new HashMap<>(1);
        passThroughAttributes = new HashMap<>(1);
        rendererType = getClass().getName();
    }

    /**
     * Get the attributes.
     *
     * @return the attributes.
     */
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    /**
     * Get the children.
     *
     * @return the children.
     */
    @Override
    public List<UIComponent> getChildren() {
        return children;
    }

    /**
     * Get the facet.
     *
     * @param facetName the facet name.
     * @return the facet.
     */
    @Override
    public UIComponent getFacet(String facetName) {
        return facets.get(facetName);
    }

    /**
     * Get the facets.
     *
     * @return the facets.
     */
    @Override
    public Map<String, UIComponent> getFacets() {
        return facets;
    }

    /**
     * Get the family.
     *
     * @return the family.
     */
    @Override
    public String getFamily() {
        throw new UnsupportedOperationException("A component needs a family");
    }

    /**
     * Get the parent.
     *
     * @return the parent.
     */
    @Override
    public UIComponent getParent() {
        return this.parent;
    }

    /**
     * Get the pass through attributes.
     *
     * @return the pass through attributes.
     */
    @Override
    public Map<String, String> getPassThroughAttributes() {
        return passThroughAttributes;
    }

    /**
     * Get the renderer type.
     *
     * @return the renderer type.
     */
    @Override
    public final String getRendererType() {
        return rendererType;
    }

    /**
     * Get the value expression.
     *
     * @param attributeName the attribute name.
     * @return the value expression.
     */
    @Override
    public ValueExpression getValueExpression(String attributeName) {
        ValueExpression result = null;

        if (attributes.containsKey(attributeName) && attributes.get(attributeName) instanceof ValueExpression) {
            result = (ValueExpression) attributes.get(attributeName);
        }

        return result;
    }

    /**
     * Set the parent UI component.
     *
     * @param parent the parent UI component.
     */
    @Override
    public void setParent(UIComponent parent) {
        this.parent = parent;
    }

    /**
     * Set the renderer type.
     *
     * @param rendererType the renderer type.
     */
    @Override
    public final void setRendererType(String rendererType) {
        this.rendererType = rendererType;
    }

    /**
     * Set the value expression.
     *
     * @param attributeName the attribute name.
     * @param valueExpression the value expression.
     */
    @Override
    public void setValueExpression(String attributeName, ValueExpression valueExpression) {
        attributes.put(attributeName, valueExpression);
    }
}
