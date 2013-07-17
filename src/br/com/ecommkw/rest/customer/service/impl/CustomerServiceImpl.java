/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.customer.service.impl;

import java.util.List;

import br.com.ecommkw.rest.customer.bean.CustomerBean;
import br.com.ecommkw.rest.customer.dao.impl.CustomerDAOImpl;
import br.com.ecommkw.rest.customer.service.CustomerService;

/**
 * @author Francisco Eduardo Ortiz
 */
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
	
	public List<CustomerBean> findAll() {
		return customerDAOImpl.findAll();
	}
    
    public CustomerBean findById(int id) {
    	return customerDAOImpl.findById(id);
    }
    
    public List<CustomerBean> findByName(String name) {
    	return customerDAOImpl.findByName(name);
    }
    
//    public List<CustomerBean> findByEmail(String email) {
//    	return customerDAOImpl.findByEmail(email);
//    }
//    
//    public List<CustomerBean> findByPhone(String phone) {
//    	return customerDAOImpl.findByPhone(phone);    
//    }
//    
//    public List<CustomerBean> findByAddress(String address) {
//    	return customerDAOImpl.findByAddress(address);
//    }
//
//    public List<CustomerBean> findByCityRegion(String cityRegion) {
//    	return customerDAOImpl.findByCityRegion(cityRegion);
//    }
//    
//    public List<CustomerBean> findByCpfNumber(String cpfNumber) {
//    	return customerDAOImpl.findByCpfNumber(cpfNumber);
//    }
    
    public CustomerBean create(CustomerBean customer) {
    	return customerDAOImpl.create(customer);
    }

    public CustomerBean update(CustomerBean customer) {
    	return customerDAOImpl.update(customer);
    }

    public boolean remove(int id) {
    	return customerDAOImpl.remove(id);    
    }
}
