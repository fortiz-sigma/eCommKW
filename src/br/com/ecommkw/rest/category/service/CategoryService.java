/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.category.service;

import java.util.List;

import br.com.ecommkw.rest.category.bean.CategoryBean;

/**
 * @author Francisco Eduardo Ortiz
 */
public interface CategoryService {
	
	public List<CategoryBean> findAll();
    
    public CategoryBean findById(int id);
    
    public List<CategoryBean> findByName(String name);
    
    public CategoryBean create(CategoryBean category);

    public CategoryBean update(CategoryBean category);	
    
    public boolean remove(int id);        
}
