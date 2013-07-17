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
public class UserBean implements Serializable{
	
	private static final long serialVersionUID = 8126256837359737887L;
	
	private Integer id;
	private String email;
	private String cpfNumber;
	private String name;
	private String password;
	private String group;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfNumber() {
		return cpfNumber;
	}
	public void setCpfNumber(String cpfNumber) {
		this.cpfNumber = cpfNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}