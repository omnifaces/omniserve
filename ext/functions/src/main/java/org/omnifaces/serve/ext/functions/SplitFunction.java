/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:split function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "split")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class SplitFunction {

    /**
     * Split a string into an array of strings.
     *
     * @param string the input string.
     * @param delimiter the delimiter string.
     * @return the array of strings.
     */
    public static String[] split(String string, String delimiter) {
        return string.split(delimiter);
    }
}
