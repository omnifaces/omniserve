/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * A showcase for f:message.
 *
 * 
 */
@Named
@RequestScoped
public class Message1Bean {

    /**
     * Stores the date.
     */
    private Date date;

    /**
     * Get the date.
     *
     * @return the date.
     */
    public Date getDate() {
        return (Date) date.clone();
    }

    /**
     * Set the date.
     *
     * @param date the date.
     */
    public void setDate(Date date) {
        this.date = (Date) date.clone();
    }

    /**
     * Do it.
     *
     * @return null to navigate to same page.
     */
    public String doIt() {
        return null;
    }
}
