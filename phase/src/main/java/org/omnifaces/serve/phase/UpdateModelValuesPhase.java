/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.phase;

import javax.el.ValueExpression;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.omnifaces.serve.component.EditableValueHolder;
import org.omnifaces.serve.component.UIComponent;
import org.omnifaces.serve.component.UIViewRoot;
import org.omnifaces.serve.vist.DefaultVisitContext;
import org.omnifaces.serve.vist.DefaultVisitTree;
import org.omnifaces.serve.vist.VisitCallback;
import org.omnifaces.serve.vist.VisitContext;
import org.omnifaces.serve.vist.VisitResult;

/**
 * The "UPDATE_MODEL_VALUES" phase.
 */
@ApplicationScoped
@Default
@ServePhaseId("UPDATE_MODEL_VALUES")
public class UpdateModelValuesPhase extends BasePhase {

    /**
     * Execute the phase.
     *
     * @param context the context.
     */
    @Override
    public void execute(PhaseContext context) {
        context.setCurrentPhaseId(getId());
        if (!shouldSkip(context)) {
            UIViewRoot viewRoot = context.getViewRoot();
            DefaultVisitTree visitTree = new DefaultVisitTree();
            DefaultVisitContext visitContext = new DefaultVisitContext();
            visitTree.visitTree(visitContext, viewRoot,
                    (VisitCallback<VisitContext, UIComponent>) (VisitContext visitContextParam,
                            UIComponent target) -> {
                        VisitResult result = VisitResult.ACCEPT;
                        if (target instanceof EditableValueHolder) {
                            EditableValueHolder evh = (EditableValueHolder) target;
                            Object localValue = evh.getLocalValue();
                            if (evh.isLocalValueSet()) {
                                ValueExpression ve = target.getValueExpression("value");
                                if (ve != null && !ve.isLiteralText()) {
                                    ve.setValue(context.getELContext(), localValue);
                                    evh.setLocalValue(null);
                                    evh.setLocalValueSet(false);
                                }
                            }
                        }
                        return result;
                    });
        }
    }

    /**
     * Get the phase id.
     *
     * @return the phase id.
     */
    @Override
    public PhaseId getId() {
        return PhaseId.UPDATE_MODEL_VALUES;
    }
}
