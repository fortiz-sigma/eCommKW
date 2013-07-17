/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

/**
 * @author Francisco Eduardo Ortiz
 */
public abstract class AbstractDAO {
	
	protected final Logger log = Logger.getLogger(getClass());
	
	protected Connection connection = null;
	protected ResultSet resultSet = null;
	protected PreparedStatement preparedStatement = null;
	protected CallableStatement callableStatement = null;
	
	protected Connection openMySQLConnection() throws NamingException, SQLException{
		return connection = ConnectionFactory.getMySQLConnection();
	}
	
	protected Connection openOracleConnection() throws NamingException, SQLException{
		return connection = ConnectionFactory.getOracleConnection();
	}
	
	protected void closeConnection(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
		if (preparedStatement != null) preparedStatement.close();
		if (resultSet != null) resultSet.close();
		if (connection != null) connection.close();
	}
	
	protected void closeConnection(Connection connection, ResultSet resultSet, CallableStatement callableStatement) throws SQLException {
		if (callableStatement != null) callableStatement.close();
		if (resultSet != null) resultSet.close();
		if (connection != null) connection.close();
	}
	
}
