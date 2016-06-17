/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.zxing;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * The filter for ZXing processing.
 */
@WebFilter(filterName = "org.omnifaces.serve.ext.zxing.ZXingFilter", urlPatterns = {"/*"})
public class ZXingFilter implements Filter {

    /**
     * Stores the prefix.
     */
    private static final String PREFIX = "org.omnifaces.serve.ext.zxing.";

    /**
     * Stores the writer name.
     */
    private static final String WRITER_NAME = "org.omnifaces.serve.ext.zxing.ZXingFilter.writerName";

    /**
     * Stores the "ZXing" writer map.
     */
    private final HashMap<String, ZXingWriter> writerMap = new HashMap<>();

    /**
     * Constructor.
     */
    public ZXingFilter() {
    }

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
        if (request.getParameter(WRITER_NAME) != null) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            String writerClassName = getBarcodeClassName(request);
            OutputStream outputStream = null;
            try {
                String value = request.getParameter("value");
                Integer width = Integer.valueOf(request.getParameter("width"));
                Integer height = Integer.valueOf(request.getParameter("height"));
                ZXingWriter writer = getBarcodeWriter(writerClassName);
                httpServletResponse.setContentType("image/png");
                httpServletResponse.setHeader("Cache-Control", "no-store");
                httpServletResponse.setHeader("Pragma", "no-cache");
                httpServletResponse.setDateHeader("Expires", 0);
                outputStream = response.getOutputStream();
                writer.writeBarcode(value, height, width, outputStream);
                outputStream.flush();
                outputStream.close();
            } catch (IOException ioe) { // NOPMD
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException ioe) { // NOPMD
                    }
                }
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    /**
     * Get the writer.
     *
     * @param name the name of the barcode writer.
     * @return the writer, or null.
     */
    private ZXingWriter getBarcodeWriter(String name) {
        ZXingWriter writer = writerMap.get(name);
        if (writer == null) {
            Class<?> clazz;
            try {
                clazz = getClass().getClassLoader().loadClass(name);
                writer = (ZXingWriter) clazz.newInstance();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException throwable) { // NOPMD
            }
            if (writer != null) {
                writerMap.put(name, writer);
            }
        }
        return writer;
    }

    /**
     * Get the barcode class name if any.
     *
     * @param request the HTTP servlet request.
     * @return the barcode class name.
     */
    private String getBarcodeClassName(ServletRequest request) {
        return PREFIX + request.getParameter(WRITER_NAME) + "Writer";
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
