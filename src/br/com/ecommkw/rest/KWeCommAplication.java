/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.ecommkw.rest.product.service.impl.ProductRestServiceImpl;

/**
 * @author Francisco Eduardo Ortiz
 */

@ApplicationPath("/rest")
public class KWeCommAplication extends Application {
	
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public KWeCommAplication() {
		
		classes.add(ProductRestServiceImpl.class);
	}
	
	public Set<Class<?>> getClasses() {
		return this.classes;
	}	
}