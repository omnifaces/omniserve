/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.validator;

import javax.el.ValueExpression;

/**
 * A validator.
 *
 * @param <T> the type to validate against.
 */
public interface Validator<T> {

    /**
     * Get the value expression.
     *
     * @param attributeName the attribute name.
     * @return the value expression, or null if not found.
     */
    default ValueExpression getValueExpression(String attributeName) {
        throw new UnsupportedOperationException("To use a VE on your validator you need to implement this");
    }

    /**
     * Is the validator disabled.
     *
     * @return true if it is, false otherwise.
     */
    default boolean isDisabled() {
        return false;
    }

    /**
     * Set the validator disabled flag.
     *
     * @param disabled the disabled flag.
     */
    default void setDisabled(boolean disabled) {
    }

    /**
     * Set the value expression.
     *
     * @param attributeName the attribute name.
     * @param valueExpression the value expression.
     */
    default void setValueExpression(String attributeName, ValueExpression valueExpression) {
        throw new UnsupportedOperationException("To use a VE on your validator you need to implement this");
    }

    /**
     * Validate the object.
     *
     * @param object the object to validate.
     */
    void validate(T object);
}
