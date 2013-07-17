/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.customer.bean;

import java.io.Serializable;

/**
 * @author Francisco Eduardo Ortiz
 */
public class UserGroupBean implements Serializable {
		
	private static final long serialVersionUID = 3122117267121992187L;
	
	private String login;
	
	private String group;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
}