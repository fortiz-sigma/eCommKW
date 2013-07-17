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

public class CustomerBean implements Serializable {

	private static final long serialVersionUID = 4852222149947224783L;

	private Integer id;

	private String name;

	private String email;

	private String phone;

	private String address;

	private String cityRegion;

	private String cpfNumber;

	private String password;

	public CustomerBean() {
	}

	public CustomerBean(Integer id) {
		this.id = id;
	}

	public CustomerBean(Integer id, String name, String email, String phone,
			String address, String cityRegion, String cpfNumber, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.cityRegion = cityRegion;
		this.cpfNumber = cpfNumber;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCityRegion() {
		return cityRegion;
	}

	public void setCityRegion(String cityRegion) {
		this.cityRegion = cityRegion;
	}

	public String getCpfNumber() {
		return cpfNumber;
	}

	public void setCpfNumber(String cpfNumber) {
		this.cpfNumber = cpfNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}