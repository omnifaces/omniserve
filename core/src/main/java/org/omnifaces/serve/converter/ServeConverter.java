/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.converter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 * The qualifier for a Converter.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface ServeConverter {

    /**
     * Stores the converter id.
     *
     * @return the converter id.
     */
    String value() default "";

    /**
     * Stores the for class.
     *
     * @return the for class.
     */
    Class forClass() default Object.class;
}
