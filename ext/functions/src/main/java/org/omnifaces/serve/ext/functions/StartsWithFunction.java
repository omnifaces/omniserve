/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:startsWith function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "startsWith")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class StartsWithFunction {

    /**
     * Determine if this string start with the given string.
     *
     * @param string the input string.
     * @param startsWith the startsWith string.
     * @return the lower case string.
     */
    public static boolean startsWith(String string, String startsWith) {
        return string.startsWith(startsWith);
    }
}
