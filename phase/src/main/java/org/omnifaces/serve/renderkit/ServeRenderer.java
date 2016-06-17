/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.renderkit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 * The qualifier for a renderer.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Inherited
public @interface ServeRenderer {

    /**
     * Stores the render kid id.
     *
     * @return the render kit id.
     */
    String renderKitId() default "HTML_BASIC";

    /**
     * Stores the renderer type.
     *
     * @return the renderer type.
     */
    String rendererType();

    /**
     * Stores the component family.
     *
     * @return the component family.
     */
    String componentFamily() default "org.omnifaces.serve.component.custom";
}
