/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:substringBefore function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "substringBefore")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class SubstringBeforeFunction {

    /**
     * Get a string before the given string.
     *
     * @param string the input string.
     * @param before the before string.
     * @return the lower case string.
     */
    public static String substringBefore(String string, String before) {
        String result = "";
        int position = string.indexOf(before);
        if (position != -1) {
            result = string.substring(0, position);
        }
        return result;
    }
}
