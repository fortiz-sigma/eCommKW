/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.product.service;

import java.util.List;

import br.com.ecommkw.rest.product.bean.ProductBean;

/**
 * @author Francisco Eduardo Ortiz
 */
public interface ProductService {   

	public List<ProductBean> findAll();
    
    public ProductBean findById(int id);
    
    public List<ProductBean> findByName(String name);
    
    public ProductBean create(ProductBean product);

    public ProductBean update(ProductBean product);

    public boolean remove(int id);        
}