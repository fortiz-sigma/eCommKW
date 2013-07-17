/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.product.service.impl;

import java.util.List;

import javax.ws.rs.Path;

import br.com.ecommkw.rest.product.bean.ProductBean;
import br.com.ecommkw.rest.product.service.ProductRestService;

/**
 * @author Francisco Eduardo Ortiz
 */
@Path("/products")
public class ProductRestServiceImpl implements ProductRestService {
	
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();	

	public List<ProductBean> findAll() {
		return productServiceImpl.findAll();
	}
    
    public ProductBean findById(int id) {
    	return productServiceImpl.findById(id);
    }
    
    public List<ProductBean> findByName(String name) {
    	return productServiceImpl.findByName(name);
    }
    
    public ProductBean create(ProductBean product) {
    	return productServiceImpl.create(product);
    }

    public ProductBean update(ProductBean product) {
    	return productServiceImpl.update(product);
    }

    public boolean remove(int id) {
    	return productServiceImpl.remove(id);        
    }
}