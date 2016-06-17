/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.component;

import java.util.List;
import org.omnifaces.serve.event.ValueChangeListener;
import org.omnifaces.serve.validator.Validator;

/**
 * An editable value holder.
 */
public interface EditableValueHolder extends ValueHolder {

    /**
     * Add a validator.
     *
     * @param validator the validator.
     */
    void addValidator(Validator validator);

    /**
     * Add a value change listener.
     *
     * @param valueChangeListener the value change listener.
     */
    void addValueChangeListener(ValueChangeListener valueChangeListener);

    /**
     * Get the submitted value.
     *
     * @return the submitted value.
     */
    Object getSubmittedValue();

    /**
     * Get the validators.
     *
     * @return the validators.
     */
    List<Validator> getValidators();

    /**
     * Get the list of value change listeners.
     *
     * @return the list of value change listeners.
     */
    List<ValueChangeListener> getValueChangeListeners();

    /**
     * Set the submitted value.
     *
     * @param submittedValue the submitted value.
     */
    void setSubmittedValue(Object submittedValue);
}
