/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.el;

import java.beans.FeatureDescriptor;
import java.util.Iterator;
import javax.el.ELContext;
import javax.el.ELResolver;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * A scoped attribute EL resolver.
 */
@ApplicationScoped
public class ScopedAttributeELResolver extends ELResolver {

    /**
     * Stores the request.
     */
    @Inject
    HttpServletRequest request;

    /**
     * Get the value.
     *
     * @param elContext the EL context.
     * @param base the base.
     * @param property the property.
     * @return the value.
     */
    @Override
    public Object getValue(ELContext elContext, Object base, Object property) {
        Object result = null;

        if (base == null) {
            elContext.setPropertyResolved(true);
            String propertyString = property.toString();

            if (request.getAttribute(propertyString) != null) {
                result = request.getAttribute(propertyString);
            }
        }

        return result;
    }

    /**
     * Get the type.
     *
     * @param elContext the EL context.
     * @param base the base.
     * @param property the property.
     * @return the type.
     */
    @Override
    public Class<?> getType(ELContext elContext, Object base, Object property) {
        Class<?> result = null;

        if (base == null) {
            elContext.setPropertyResolved(true);
            String propertyString = property.toString();

            if (request.getAttribute(propertyString) != null) {
                result = request.getAttribute(propertyString).getClass();
            } else {
                result = Object.class;
            }
        }

        return result;
    }

    @Override
    public void setValue(ELContext elc, Object o, Object o1, Object o2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isReadOnly(ELContext elc, Object o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext elc, Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Class<?> getCommonPropertyType(ELContext elc, Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
