/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:contains function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "contains")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class ContainsFunction {

    /**
     * Determine if this string contains the given string.
     *
     * @param string the input string.
     * @param contains the contains string.
     * @return true if it does, false otherwise
     */
    public static boolean contains(String string, String contains) {
        return string.contains(contains);
    }
}
