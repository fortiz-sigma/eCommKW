/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.category.service.impl;

import java.util.List;

import javax.ws.rs.Path;

import br.com.ecommkw.rest.category.bean.CategoryBean;
import br.com.ecommkw.rest.category.service.CategoryRestService;

/**
 * @author Francisco Eduardo Ortiz
 */
@Path("/categories")
public class CategoryRestServiceImpl implements CategoryRestService {
	
	CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
	
	public List<CategoryBean> findAll() {
		return categoryServiceImpl.findAll();
	}
    
    public CategoryBean findById(int id) {
    	return categoryServiceImpl.findById(id);
    }
    
    public List<CategoryBean> findByName(String name) {
    	return categoryServiceImpl.findByName(name);
    }
    
    public CategoryBean create(CategoryBean category) {
    	return categoryServiceImpl.create(category);
    }

    public CategoryBean update(CategoryBean category) {
    	return categoryServiceImpl.update(category);	
    }
    
    public boolean remove(int id) {
    	return categoryServiceImpl.remove(id);    	
    }
}
