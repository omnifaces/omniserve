/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.view;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.omnifaces.serve.phase.PhaseContext;

/**
 * A Test ViewLanguage.
 */
@ApplicationScoped
@Default
public class TestViewLanguage implements ViewLanguage {

    @Override
    public void buildView(PhaseContext context) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createView(PhaseContext context, String viewId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void renderView(PhaseContext context) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void restoreView(PhaseContext context, String viewId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
