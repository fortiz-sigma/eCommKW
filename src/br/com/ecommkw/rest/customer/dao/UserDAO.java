/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.customer.dao;

import br.com.ecommkw.rest.customer.bean.UserBean;

/**
 * @author Francisco Eduardo Ortiz
 */
public interface UserDAO {

	public UserBean login(String login, String password);
	
    public boolean save(UserBean user, String newLogin, String newPassword);    
    
    public boolean create(UserBean user);

    public boolean update(UserBean user, String newLogin, String newPassword);

    public boolean remove(UserBean user);  	

}
