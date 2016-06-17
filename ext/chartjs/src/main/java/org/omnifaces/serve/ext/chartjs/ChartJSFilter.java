/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.chartjs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * The filter for ChartJS processing.
 */
@WebFilter(filterName = "org.omnifaces.serve.ext.chartjs.ChartJSFilter", urlPatterns = {"/*"})
public class ChartJSFilter implements Filter {

    /**
     * Destroy the filter.
     */
    @Override
    public void destroy() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing.
     * @exception ServletException when a filter error occurs.
     * @exception IOException if an input/output error occurs.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (request.getParameter("org.omnifaces.serve.ext.chartjs.ChartJs") != null) {
            try (InputStream inputStream = getClass().getResourceAsStream("/org/omnifaces/serve/ext/chartjs/Chart.js");
                    OutputStream outputStream = response.getOutputStream()) {
                int read = inputStream.read();
                while (read != -1) {
                    outputStream.write(read);
                    read = inputStream.read();
                }
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    /**
     * Initialize the filter.
     *
     * @param filterConfig the configuration of the filter.
     */
    @Override
    public void init(FilterConfig filterConfig) {
    }
}
