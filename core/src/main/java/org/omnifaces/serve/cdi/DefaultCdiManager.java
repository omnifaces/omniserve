/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.cdi;

import java.lang.annotation.Annotation;
import java.util.Set;
import javax.el.ArrayELResolver;
import javax.el.BeanELResolver;
import javax.el.CompositeELResolver;
import javax.el.ELResolver;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.CDI;
import org.omnifaces.serve.el.HttpServletRequestELResolver;
import org.omnifaces.serve.el.ScopedAttributeELResolver;

/**
 * The default CDI manager.
 */
@ApplicationScoped
@Default
public class DefaultCdiManager implements CdiManager {

    /**
     * Stores the EL resolver.
     */
    private CompositeELResolver elResolver;

    /**
     * Does the type exist.
     *
     * @param clazz the type.
     * @param annotations the annotations.
     * @return true if it does, false otherwise.
     */
    @Override
    public boolean exists(Class<?> clazz, Annotation... annotations) {
        Set<Bean<?>> beans = CDI.current().getBeanManager().getBeans(clazz, annotations);
        return !beans.isEmpty();
    }

    /**
     * Get the EL resolver.
     *
     * @return the EL resolver.
     */
    @Override
    public ELResolver getELResolver() {
        if (elResolver == null) {
            elResolver = new CompositeELResolver();
            elResolver.add(CDI.current().getBeanManager().getELResolver());
            elResolver.add(new ArrayELResolver());
            elResolver.add(new BeanELResolver());
            elResolver.add(getInstance(HttpServletRequestELResolver.class));
            elResolver.add(getInstance(ScopedAttributeELResolver.class));
        }
        return elResolver;
    }

    /**
     * Get the instance.
     *
     * @param clazz the class.
     * @param annotations the annotations.
     * @return the instance.
     */
    @Override
    public <T extends Object> T getInstance(Class<T> clazz, Annotation... annotations) {
        return CDI.current().select(clazz, annotations).get();
    }
}
