/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:endsWith function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "endsWith")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class EndsWithFunction {

    /**
     * Determine if this string ends with the given string.
     *
     * @param string the input string.
     * @param endsWith the endsWith string.
     * @return the lower case string.
     */
    public static boolean startsWith(String string, String endsWith) {
        return string.endsWith(endsWith);
    }
}
