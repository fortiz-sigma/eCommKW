/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.customer.service;

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

import br.com.ecommkw.rest.customer.bean.CustomerBean;

/**
 * @author Francisco Eduardo Ortiz
 */
public interface CustomerRestService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })	
	public List<CustomerBean> findAll();
    
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
    public CustomerBean findById(@PathParam("id") int id);
    
	@GET @Path("search/{name}")
	@Produces({ MediaType.APPLICATION_JSON })    
    public List<CustomerBean> findByName(@PathParam("name") String name);
    
//	@GET @Path("search/{email}")
//	@Produces({ MediaType.APPLICATION_JSON })	
//    public List<CustomerBean> findByEmail(@PathParam("email") String email);
//    
//	@GET @Path("search/{phone}")
//	@Produces({ MediaType.APPLICATION_JSON })	
//    public List<CustomerBean> findByPhone(@PathParam("phone") String phone);    
//    
//	@GET @Path("search/{address}")
//	@Produces({ MediaType.APPLICATION_JSON })	
//    public List<CustomerBean> findByAddress(@PathParam("address") String address);
//
//	@GET @Path("search/{cityRegion}")
//	@Produces({ MediaType.APPLICATION_JSON })	
//    public List<CustomerBean> findByCityRegion(@PathParam("cityRegion") String cityRegion);
//    
//	@GET @Path("search/{cpfNumber}")
//	@Produces({ MediaType.APPLICATION_JSON })	
//    public List<CustomerBean> findByCpfNumber(@PathParam("cpfNumber") String cpfNumber);
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })    
    public CustomerBean create(CustomerBean customer);

	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })	
    public CustomerBean update(CustomerBean customer);

	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })	
    public boolean remove(@PathParam("id") int id); 	
	
}
