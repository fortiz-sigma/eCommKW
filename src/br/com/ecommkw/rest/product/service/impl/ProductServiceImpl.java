/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.product.service.impl;

import java.util.List;

import br.com.ecommkw.rest.product.bean.ProductBean;
import br.com.ecommkw.rest.product.dao.impl.ProductDAOImpl;
import br.com.ecommkw.rest.product.service.ProductService;

/**
 * @author Francisco Eduardo Ortiz
 */
public class ProductServiceImpl implements ProductService {
	
	ProductDAOImpl productDAOImpl = new ProductDAOImpl();	

	public List<ProductBean> findAll() {
		return productDAOImpl.findAll();
	}
    
    public ProductBean findById(int id) {
    	return productDAOImpl.findById(id);
    }
    
    public List<ProductBean> findByName(String name) {
    	return productDAOImpl.findByName(name);
    }
    
    public ProductBean create(ProductBean product) {
    	return productDAOImpl.create(product);
    }

    public ProductBean update(ProductBean product) {
    	return productDAOImpl.update(product);
    }

    public boolean remove(int id) {
    	return productDAOImpl.remove(id);        
    }
}