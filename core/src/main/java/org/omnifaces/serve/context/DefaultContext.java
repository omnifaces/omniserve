/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.context;

import java.util.Locale;
import javax.el.ELContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.omnifaces.serve.cdi.CdiManager;
import org.omnifaces.serve.el.ServeELContext;

/**
 * The default context.
 */
public abstract class DefaultContext implements Context {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Stores the character encoding.
     */
    private String characterEncoding;

    /**
     * Stores the EL context.
     */
    private ELContext elContext;

    /**
     * Stores the HTTP servlet request.
     */
    @Inject
    protected HttpServletRequest request;

    /**
     * Stores the HTTP servlet response.
     */
    private HttpServletResponse response;

    /**
     * Get the character encoding.
     *
     * @return the character encoding.
     */
    @Override
    public String getCharacterEncoding() {
        return characterEncoding;
    }

    /**
     * Get the EL context.
     *
     * @return the EL context.
     */
    @Override
    public ELContext getELContext() {
        if (elContext == null) {
            elContext = (ELContext) cdiManager.getInstance(ServeELContext.class);
        }
        return elContext;
    }

    /**
     * Get the locale.
     *
     * @return the locale.
     */
    @Override
    public Locale getLocale() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get the HTTP servlet response.
     *
     * @return the HTTP servlet response.
     */
    @Override
    public HttpServletResponse getResponse() {
        return response;
    }

    /**
     * Set the character encoding.
     *
     * @param characterEncoding the character encoding.
     */
    @Override
    public void setCharacterEncoding(String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }

    /**
     * Set the response.
     *
     * @param response the response.
     */
    @Override
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
