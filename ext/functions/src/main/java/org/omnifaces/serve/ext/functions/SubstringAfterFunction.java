/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:substringAfter function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "substringAfter")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class SubstringAfterFunction {

    /**
     * Get a string after the given string.
     *
     * @param string the input string.
     * @param after the after string.
     * @return the lower case string.
     */
    public static String substringAfter(String string, String after) {
        String result = "";
        int position = string.indexOf(after) + after.length();
        if (position != -1) {
            result = string.substring(position);
        }
        return result;
    }
}
