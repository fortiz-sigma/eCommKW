/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.category.service;

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

import br.com.ecommkw.rest.category.bean.CategoryBean;

/**
 * @author Francisco Eduardo Ortiz
 */
public interface CategoryRestService {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })	
	public List<CategoryBean> findAll();
    
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })	
    public CategoryBean findById(@PathParam("id") int id);
    
	@GET @Path("search/{name}")
	@Produces({ MediaType.APPLICATION_JSON })	
    public List<CategoryBean> findByName(@PathParam("name") String name);
    
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })    	
    public CategoryBean create(CategoryBean category);

	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })	
    public CategoryBean update(CategoryBean category);	
    
	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })		
    public boolean remove(@PathParam("id") int id);        

}
