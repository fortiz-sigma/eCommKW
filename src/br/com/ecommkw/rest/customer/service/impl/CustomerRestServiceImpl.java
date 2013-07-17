/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.customer.service.impl;

import java.util.List;

import javax.ws.rs.Path;

import br.com.ecommkw.rest.customer.bean.CustomerBean;
import br.com.ecommkw.rest.customer.service.CustomerRestService;

/**
 * @author Francisco Eduardo Ortiz
 */
@Path("/customers")
public class CustomerRestServiceImpl implements CustomerRestService {

	private CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();	
	
	public List<CustomerBean> findAll() {
		return customerServiceImpl.findAll();
	}
    
    public CustomerBean findById(int id) {
    	return customerServiceImpl.findById(id);
    }
    
    public List<CustomerBean> findByName(String name) {
    	return customerServiceImpl.findByName(name);
    }
    
//    public List<CustomerBean> findByEmail(String email) {
//    	return customerServiceImpl.findByEmail(email);
//    }
//    
//    public List<CustomerBean> findByPhone(String phone) {
//    	return customerServiceImpl.findByPhone(phone);    
//    }
//    
//    public List<CustomerBean> findByAddress(String address) {
//    	return customerServiceImpl.findByAddress(address);
//    }
//
//    public List<CustomerBean> findByCityRegion(String cityRegion) {
//    	return customerServiceImpl.findByCityRegion(cityRegion);
//    }
//    
//    public List<CustomerBean> findByCpfNumber(String cpfNumber) {
//    	return customerServiceImpl.findByCpfNumber(cpfNumber);
//    }
    
    public CustomerBean create(CustomerBean customer) {
    	return customerServiceImpl.create(customer);
    }

    public CustomerBean update(CustomerBean customer) {
    	return customerServiceImpl.update(customer);
    }

    public boolean remove(int id) {
    	return customerServiceImpl.remove(id);    
    } 	
	
}
