/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.category.bean;

import java.io.Serializable;

/**
 * @author Francisco Eduardo Ortiz
 */

public class CategoryBean implements Serializable {

	private static final long serialVersionUID = -3144247430360199234L;

	private Integer id;

	private String name;

	public CategoryBean() {
	}

	public CategoryBean(Integer id) {
		this.id = id;
	}

	public CategoryBean(Integer id, String name) {
		this.id = id;
		this.name = name;
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
}