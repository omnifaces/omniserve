/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.converter;

/**
 * A test converter.
 */
@ServeConverter(value = "testConverter")
public class TestConverter implements Converter {

    /**
     * Get as object.
     *
     * @param string the string.
     * @return the object.
     */
    @Override
    public Object getAsObject(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get as string.
     *
     * @param object the object.
     * @return the string.
     */
    @Override
    public String getAsString(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
