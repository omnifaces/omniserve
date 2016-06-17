/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.omnifaces.serve.event.ValueChangeListener;
import org.omnifaces.serve.validator.Validator;

/**
 * A UI input.
 */
public class UIInput extends UIOutput implements EditableValueHolder {

    /**
     * Stores the validators.
     */
    protected final List<Validator> validators;

    /**
     * Stores the value change listeners.
     */
    protected final List<ValueChangeListener> valueChangeListeners;

    /**
     * Constructor.
     */
    public UIInput() {
        validators = new ArrayList<>(1);
        valueChangeListeners = new ArrayList<>(1);
    }

    /**
     * Add the validator.
     *
     * @param validator the validator.
     */
    @Override
    public void addValidator(Validator validator) {
        validators.add(validator);
    }

    /**
     * Add a value change listener.
     *
     * @param valueChangeListener the value change listener.
     */
    @Override
    public void addValueChangeListener(ValueChangeListener valueChangeListener) {
        valueChangeListeners.add(valueChangeListener);
    }

    /**
     * Get the submitted value.
     *
     * @return the submitted value.
     */
    @Override
    public Object getSubmittedValue() {
        return getAttributes().get("submittedValue");
    }

    /**
     * Get the validators.
     *
     * @return the validators.
     */
    @Override
    public List<Validator> getValidators() {
        return Collections.unmodifiableList(validators);
    }

    /**
     * Get the list of value change listeners.
     *
     * @return the list of value change listeners.
     */
    @Override
    public List<ValueChangeListener> getValueChangeListeners() {
        return Collections.unmodifiableList(valueChangeListeners);
    }

    /**
     * Set the submitted value.
     *
     * @param submittedValue the submitted value.
     */
    @Override
    public void setSubmittedValue(Object submittedValue) {
        if (submittedValue == null) {
            getAttributes().remove("submittedValue");
        } else {
            getAttributes().put("submittedValue", submittedValue);
        }
    }
}
