/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * A showcase for ui:repeat.
 *
 * 
 */
@Named
@RequestScoped
public class Repeat1Bean {

    /**
     * Get the values.
     *
     * @return the values.
     */
    public List<String> getValues() {
        List<String> result = new ArrayList<>();
        result.add("1");
        result.add("2");
        result.add("3");
        result.add("4");
        result.add("5");
        return result;
    }
}
