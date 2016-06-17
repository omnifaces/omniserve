/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.showcase;

import java.util.HashMap;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * The showcase for f:passThroughAttributes.
 *
 * 
 */
@Named
@RequestScoped
public class PassThroughAttributes1Bean {

    /**
     * Get the map.
     *
     * @return the map.
     */
    public HashMap<String, Object> getMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("style", "color: blue");
        return result;
    }
}
