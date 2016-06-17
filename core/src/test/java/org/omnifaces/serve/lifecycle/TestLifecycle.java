/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.lifecycle;

import javax.enterprise.context.ApplicationScoped;
import org.omnifaces.serve.context.Context;

/**
 * A Test lifecycle.
 */
@ApplicationScoped
@LifecycleId("TEST")
public class TestLifecycle implements Lifecycle {

    /**
     * Execute the lifecycle.
     *
     * @param context the context.
     */
    @Override
    public void execute(Context context) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get the context interface.
     *
     * @return
     */
    @Override
    public Class getContextInterface() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get the id.
     *
     * @return the id.
     */
    @Override
    public String getId() {
        return "COMPONENT";
    }
}
