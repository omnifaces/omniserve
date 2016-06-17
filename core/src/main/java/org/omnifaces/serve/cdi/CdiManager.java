/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.cdi;

import java.lang.annotation.Annotation;
import javax.el.ELResolver;

/**
 * The interface for our CDI manager.
 */
public interface CdiManager {

    /**
     * Does an match exist?
     *
     * @param clazz the class.
     * @param annotations the annotations.
     * @return true if it does, false otherwise.
     */
    boolean exists(Class<?> clazz, Annotation... annotations);

    /**
     * Get the EL resolver.
     *
     * @return the EL resolver.
     */
    ELResolver getELResolver();

    /**
     * Give an instance.
     *
     * @param <T> type type to return.
     * @param clazz the class type.
     * @param annotations the annotations.
     * @return the instance.
     */
    <T extends Object> T getInstance(Class<T> clazz, Annotation... annotations);
}
