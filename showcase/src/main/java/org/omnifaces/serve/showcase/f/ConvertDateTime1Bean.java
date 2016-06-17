/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.f;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * The showcase for f:convertDateTime.
 *
 * 
 */
@Named
@RequestScoped
public class ConvertDateTime1Bean {

    /**
     * Get the date.
     *
     * @return the date.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public Date getDate() {
        return new Date(2016 - 1900, 0, 1);
    }
}
