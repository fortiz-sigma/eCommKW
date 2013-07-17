/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.product.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.ecommkw.rest.product.bean.ProductBean;

/**
 * @author Francisco Eduardo Ortiz
 */
public interface ProductRestService {   

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ProductBean> findAll();
    
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })	
    public ProductBean findById(@PathParam("id") int id);
    
	@GET
	@Path("search/{name}")
	@Produces({ MediaType.APPLICATION_JSON })    
    public List<ProductBean> findByName(@PathParam("name") String name);
    
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })	
    public ProductBean create(ProductBean product);

	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })	
    public ProductBean update(ProductBean product);

	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })	
    public boolean remove(@PathParam("id") int id);    
    
}