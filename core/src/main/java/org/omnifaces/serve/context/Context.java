/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.context;

import java.util.Locale;
import javax.el.ELContext;
import javax.servlet.http.HttpServletResponse;

/**
 * The context.
 */
public interface Context {

    /**
     * Get the character encoding.
     *
     * @return the character encoding.
     */
    String getCharacterEncoding();

    /**
     * Get the EL context.
     *
     * @return the EL context.
     */
    ELContext getELContext();

    /**
     * Get the locale.
     *
     * @return the locale.
     */
    Locale getLocale();

    /**
     * Get the HTTP servlet response.
     *
     * @return the HTTP servlet response.
     */
    HttpServletResponse getResponse();

    /**
     * Set the character encoding.
     *
     * @param characterEncoding the character encoding.
     */
    void setCharacterEncoding(String characterEncoding);

    /**
     * Set the HTTP servlet response.
     *
     * @param response the HTTP servlet response.
     */
    void setResponse(HttpServletResponse response);
}
