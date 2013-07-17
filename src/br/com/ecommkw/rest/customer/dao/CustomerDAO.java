/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.customer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.ecommkw.rest.customer.bean.CustomerBean;

/**
 * @author Francisco Eduardo Ortiz
 */
public interface CustomerDAO {   

	public List<CustomerBean> findAll();
    
    public CustomerBean findById(int id);
    
    public List<CustomerBean> findByName(String name);
    
    public List<CustomerBean> findByEmail(String email);
    
    public List<CustomerBean> findByPhone(String phone);    
    
    public List<CustomerBean> findByAddress(String address);

    public List<CustomerBean> findByCityRegion(String cityRegion);
    
    public List<CustomerBean> findByCpfNumber(String cpfNumber);
    
    public CustomerBean save(CustomerBean customer);    
    
    public CustomerBean create(CustomerBean customer);

    public CustomerBean update(CustomerBean customer);

    public boolean remove(int id);    
    
    CustomerBean processRow(ResultSet rs) throws SQLException;    
}