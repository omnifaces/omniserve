/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase.c;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * A showcase for c:forEach.
 *
 * 
 */
@Named
@RequestScoped
public class ForEach1Bean {

    /**
     * Get the items.
     *
     * @return the items.
     */
    public List<String> getItems() {
        List<String> result = new ArrayList<>();
        result.add("1");
        result.add("2");
        result.add("3");
        result.add("4");
        result.add("5");
        return result;
    }
}
