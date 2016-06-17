/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import org.omnifaces.serve.converter.Converter;
import javax.enterprise.context.Dependent;
import org.omnifaces.serve.converter.ServeConverter;

/**
 * Custom converter for f:converter showcase #1.
 *
 * 
 */
@Dependent
@ServeConverter(value = "converter1Converter")
public class Converter1Converter implements Converter {

    /**
     * Get as an object.
     *
     * @param string the string.
     * @return the object.
     */
    @Override
    public Object getAsObject(String string) {
        return new Converter1();
    }

    /**
     * Get as a string.
     *
     * @param value the value.
     * @return the string.
     */
    @Override
    public String getAsString(Object value) {
        return value.toString();
    }
}
