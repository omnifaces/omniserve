/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:toUpperCase function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "toUpperCase")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class ToUpperCaseFunction {

    /**
     * Converts a string to upper case.
     *
     * @param string the input string.
     * @return the upper case string.
     */
    public static String toUpperCase(String string) {
        return string.toUpperCase();
    }
}
