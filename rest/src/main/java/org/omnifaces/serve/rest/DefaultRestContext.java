/*
 * Copyright (c) 2016 OmniFaces.org. All Rights Reserved.
 */
package org.omnifaces.serve.rest;

import javax.enterprise.context.RequestScoped;
import org.omnifaces.serve.context.DefaultContext;

/**
 * The default REST context.
 */
@RequestScoped
public class DefaultRestContext extends DefaultContext implements RestContext {

}
