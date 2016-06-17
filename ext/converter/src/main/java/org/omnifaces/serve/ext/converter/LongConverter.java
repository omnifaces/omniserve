/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.converter;

import org.omnifaces.serve.converter.Converter;
import org.omnifaces.serve.converter.ConverterException;
import org.omnifaces.serve.converter.ServeConverter;

/**
 * A long converter.
 */
@ServeConverter(value = "org.omnifaces.serve.ext.converter.LongConverter", forClass = Object.class)
public class LongConverter implements Converter {

    /**
     * Get as an object.
     *
     * @param string the string.
     * @return the object.
     */
    @Override
    public Object getAsObject(String string) {
        Long result = null;

        if (!"".equals(string)) {
            try {
                result = Long.valueOf(string);
            } catch (NumberFormatException nfe) {
                throw new ConverterException("Unable to convert to a Long", nfe);
            }
        }

        return result;
    }

    /**
     * Get as a string.
     *
     * @param value the value.
     * @return the string.
     */
    @Override
    public String getAsString(Object value) {
        String result = "";

        if (value != null) {
            result = value.toString();
        }

        return result;
    }
}
