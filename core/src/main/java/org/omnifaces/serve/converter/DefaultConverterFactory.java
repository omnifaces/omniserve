/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;

/**
 * The default factory for converters.
 */
@ApplicationScoped
@Default
public class DefaultConverterFactory implements ConverterFactory {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Create the converter.
     *
     * @param converterId the converter id.
     * @return the converter, or null if not found.
     */
    @Override
    public Converter createConverter(String converterId) {
        Converter result = null;
        if (cdiManager.exists(Converter.class, new ServeConverterLiteral(converterId, Object.class))) {
            result = cdiManager.getInstance(Converter.class, new ServeConverterLiteral(converterId, Object.class));
        }
        return result;
    }

    /**
     * Create the converter.
     *
     * @param expectedType the expected type.
     * @return the converter, or null if not found.
     */
    @Override
    public Converter createConverter(Class<?> expectedType) {
        Converter result = null;
        if (cdiManager.exists(Converter.class, new ServeConverterLiteral("", expectedType))) {
            result = cdiManager.getInstance(Converter.class, new ServeConverterLiteral("", expectedType));
        }
        return result;
    }
}
