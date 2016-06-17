/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:indexOf function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "indexOf")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class IndexOfFunction {

    /**
     * Get the first index of the given substring.
     *
     * @param string the input string.
     * @param substring the substring.
     * @return the index.
     */
    public static int indexOf(String string, String substring) {
        return string.indexOf(substring);
    }
}
