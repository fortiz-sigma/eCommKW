/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.customer.dao;

import br.com.ecommkw.rest.customer.bean.UserGroupBean;

/**
 * @author Francisco Eduardo Ortiz
 */
public interface UserGroupDAO {
	
    public boolean create(UserGroupBean userGroup);

    public boolean remove(UserGroupBean userGroup);  	

}
