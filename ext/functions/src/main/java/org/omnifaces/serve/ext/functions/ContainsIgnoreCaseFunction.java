/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:containsIgnoreCase function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "containsIgnoreCase")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class ContainsIgnoreCaseFunction {

    /**
     * Determine if this string contains the given string (ignoring case).
     *
     * @param string the input string.
     * @param contains the contains string.
     * @return true if it does, false otherwise
     */
    public static boolean containsIgnoreCase(String string, String contains) {
        return string.toUpperCase().contains(contains.toUpperCase());
    }
}
