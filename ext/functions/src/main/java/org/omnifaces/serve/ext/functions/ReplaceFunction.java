/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:replace function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "replace")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class ReplaceFunction {

    /**
     * Replace content in a string.
     *
     * @param string the input string.
     * @param match the string to match.
     * @param replacement the string to replace with.
     * @return the string with replacement done.
     */
    public static String replace(String string, String match, String replacement) {
        return string.replaceAll(match, replacement);
    }
}
