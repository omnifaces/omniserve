/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.el;

import java.util.HashMap;
import java.util.Map;
import javax.el.ValueExpression;
import javax.el.VariableMapper;

/**
 * The servlet-based EL variable mapper.
 */
public class ServeServletVariableMapper extends VariableMapper {

    /**
     * Stores the variables.
     */
    private final Map<String, ValueExpression> variables = new HashMap<>();

    /**
     * Resolve the variable.
     *
     * @param variable the variable.
     * @return the value expression.
     */
    @Override
    public ValueExpression resolveVariable(String variable) {
        return variables.get(variable);
    }

    /**
     * Set the variable.
     *
     * @param variable the variable.
     * @param valueExpression the value expression.
     * @return the previous value expression.
     */
    @Override
    public ValueExpression setVariable(String variable, ValueExpression valueExpression) {
        ValueExpression result;

        if (valueExpression == null) {
            result = variables.remove(variable);
        } else {
            result = variables.put(variable, valueExpression);
        }

        return result;
    }
}
