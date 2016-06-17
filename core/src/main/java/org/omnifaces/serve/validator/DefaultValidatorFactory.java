/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.validator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import org.omnifaces.serve.cdi.CdiManager;

/**
 * The default factory for validators.
 */
@ApplicationScoped
@Default
public class DefaultValidatorFactory implements ValidatorFactory {

    /**
     * Stores the CDI manager.
     */
    @Inject
    private CdiManager cdiManager;

    /**
     * Create the validator.
     *
     * @param validatorId the validator id.
     * @return the validator.
     */
    @Override
    public Validator createValidator(String validatorId) {
        return cdiManager.getInstance(Validator.class, new ServeValidatorLiteral(validatorId));
    }
}
