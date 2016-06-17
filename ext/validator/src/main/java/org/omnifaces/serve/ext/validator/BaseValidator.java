/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.ext.validator;

import java.util.HashMap;
import java.util.Map;
import javax.el.ValueExpression;
import javax.inject.Inject;
import org.omnifaces.serve.context.Context;
import org.omnifaces.serve.validator.Validator;

/**
 * Our base validator.
 */
abstract class BaseValidator implements Validator {

    /**
     * Stores the attributes.
     */
    protected final Map<String, Object> attributes;

    /**
     * Stores the context.
     */
    @Inject
    protected Context context;

    /**
     * Constructor.
     */
    BaseValidator() {
        attributes = new HashMap<>(1);
    }

    /**
     * Get the value expression.
     *
     * @param attributeName the attribute name.
     * @return the value expression.
     */
    @Override
    public ValueExpression getValueExpression(String attributeName) {
        ValueExpression result = null;
        if (attributes.containsKey(attributeName)
                && attributes.get(attributeName) instanceof ValueExpression) {
            result = (ValueExpression) attributes.get(attributeName);
        }
        return result;
    }

    /**
     * Is the validator disabled.
     *
     * @return true if it is, false otherwise.
     */
    @Override
    public boolean isDisabled() {
        boolean result = false;
        if (attributes.containsKey("disabled")) {
            Object value = attributes.get("disabled");
            if (value instanceof ValueExpression) {
                ValueExpression ve = (ValueExpression) value;
                result = (boolean) ve.getValue(context.getELContext());
            } else {
                result = (boolean) value;
            }
        }
        return result;
    }

    /**
     * Set the value expression.
     *
     * @param attributeName the attribute name.
     * @param valueExpression the value expression.
     */
    @Override
    public void setValueExpression(String attributeName, ValueExpression valueExpression) {
        attributes.put(attributeName, valueExpression);
    }

    /**
     * Set the disabled flag.
     *
     * @param disabled the disabled flag.
     */
    @Override
    public void setDisabled(boolean disabled) {
        this.attributes.put("disabled", disabled);
    }
}
