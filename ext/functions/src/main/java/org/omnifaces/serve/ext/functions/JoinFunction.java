/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:join function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "join")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class JoinFunction {

    /**
     * Join all elements in a string array into one string with a delimiter.
     *
     * @param input the input strings.
     * @param delimiter the delimiter.
     * @return the joined string.
     */
    public static String join(String[] input, String delimiter) {
        return String.join(delimiter, input);
    }
}
