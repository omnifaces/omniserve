/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.vist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.omnifaces.serve.component.UIComponent;

/**
 * The default tree visit.
 */
public class DefaultVisitTree implements VisitTree<VisitContext, UIComponent> {

    /**
     * Visit the tree.
     *
     * @param context the context.
     * @param component the component.
     * @param callback the callback.
     * @return true if we are done, false otherwise.
     */
    @Override
    public boolean visitTree(VisitContext context, UIComponent component, VisitCallback callback) {
        boolean done = false;

        if (isVisitable(context, component)) {
            VisitResult result = context.invokeVisitCallback(component, callback);

            if (result == VisitResult.COMPLETE) {
                done = true;
            } else if (result == VisitResult.ACCEPT) {
                List<UIComponent> children = new ArrayList<>(component.getFacets().values());
                children.addAll(component.getChildren());
                Iterator<UIComponent> iterator = children.iterator();

                while (iterator.hasNext()) {
                    UIComponent child = iterator.next();
                    done = visitTree(context, child, callback);

                    if (done) {
                        break;
                    }
                }
            }
        }

        return done;
    }

    /**
     * Is the component visitable.
     *
     * @param context the visit context.
     * @param component the component.
     * @return true if it is, false otherwise.
     */
    @Override
    public boolean isVisitable(VisitContext context, UIComponent component) {
        return true;
    }
}
