/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.functions;

/**
 * The fn:escapeXml function.
 */
@ServeFunction(uri = "http://www.omnifaces.org/serve/ext/functions", localName = "escapeXml")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class EscapeXmlFunction {

    /**
     * Escape the XML.
     *
     * @param string the input string.
     * @return the escaped string.
     */
    public static String escapeXml(String string) {
        String result = string.replace("&", "&amp;");
        result = result.replace("'", "&quot;");
        result = result.replace("\"", "&quot;");
        result = result.replace("<", "&lt;");
        result = result.replace(">", "&gt;");
        return result;
    }
}
