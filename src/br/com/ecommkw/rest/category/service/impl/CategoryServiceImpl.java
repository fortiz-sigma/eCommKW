/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.category.service.impl;

import java.util.List;

import br.com.ecommkw.rest.category.bean.CategoryBean;
import br.com.ecommkw.rest.category.dao.impl.CategoryDAOImpl;
import br.com.ecommkw.rest.category.service.CategoryService;

/**
 * @author Francisco Eduardo Ortiz
 */
public class CategoryServiceImpl implements CategoryService {
	
	CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
	
	public List<CategoryBean> findAll() {
		return categoryDAOImpl.findAll();
	}
    
    public CategoryBean findById(int id) {
    	return categoryDAOImpl.findById(id);
    }
    
    public List<CategoryBean> findByName(String name) {
    	return categoryDAOImpl.findByName(name);
    }
    
    public CategoryBean create(CategoryBean category) {
    	return categoryDAOImpl.create(category);
    }

    public CategoryBean update(CategoryBean category) {
    	return categoryDAOImpl.update(category);	
    }
    
    public boolean remove(int id) {
    	return categoryDAOImpl.remove(id);    	
    }
}
