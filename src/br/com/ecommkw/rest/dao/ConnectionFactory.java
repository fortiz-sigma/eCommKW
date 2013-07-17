/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

/**
 * @author Francisco Eduardo Ortiz
 */
public class ConnectionFactory {

    public ConnectionFactory() {
        super();
    }
 
    public static Connection getMySQLConnection() throws NamingException, SQLException {
    	Connection conn = ConnectionHelper.getConnection();
        return conn;
    }

    public static Connection getOracleConnection() throws NamingException, SQLException {
    	Connection conn = ConnectionHelper.getConnection();    	
        return conn;
    }

}