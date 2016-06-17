/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:trim function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "trim")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class TrimFunction {

    /**
     * Trim a string.
     *
     * @param string the input string.
     * @return the trimmed string.
     */
    public static String trim(String string) {
        return string.trim();
    }
}
