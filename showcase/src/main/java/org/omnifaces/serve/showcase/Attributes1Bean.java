/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import java.util.HashMap;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * The showcase for f:attributes.
 *
 * 
 */
@Named
@RequestScoped
public class Attributes1Bean {

    /**
     * Get the map.
     *
     * @return the map.
     */
    public HashMap<String, Object> getMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("value", "this is the value from the map");
        return result;
    }
}
