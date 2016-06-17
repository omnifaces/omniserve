/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:substring function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "substring")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class SubstringFunction {

    /**
     * Substring a string.
     *
     * @param string the input string.
     * @param start the start index.
     * @param end the end index.
     * @return the lower case string.
     */
    public static String substring(String string, int start, int end) {
        return string.substring(start, end);
    }
}
