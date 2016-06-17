/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

import java.util.Collection;

/**
 * The fn:length function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "length")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class LengthFunction {

    /**
     * Determine the number of items in a collection, or the number of
     * characters in a string.
     *
     * @param input the input.
     * @return the number.
     */
    public static int length(Object input) {
        int result = -1;

        if (input instanceof String) {
            result = ((String) input).length();
        }

        if (input instanceof Collection) {
            result = ((Collection) input).size();
        }

        return result;
    }
}
