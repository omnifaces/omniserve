/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:toLowerCase function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "toLowerCase")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class ToLowerCaseFunction {

    /**
     * Converts a string to lower case.
     *
     * @param string the input string.
     * @return the lower case string.
     */
    public static String toLowerCase(String string) {
        return string.toLowerCase();
    }
}
