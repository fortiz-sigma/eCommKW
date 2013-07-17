/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.customer.dao.impl;

import java.sql.SQLException;

import javax.naming.NamingException;

import br.com.ecommkw.rest.customer.bean.UserBean;
import br.com.ecommkw.rest.customer.dao.UserDAO;
import br.com.ecommkw.rest.dao.AbstractDAO;

/**
 * @author Francisco Eduardo Ortiz
 */
public class UserDAOImpl extends AbstractDAO implements UserDAO {

	public UserBean login(String login, String password) {		

		UserBean user = new UserBean();
		
		try {
			String sql = "SELECT * FROM customer WHERE email = ? and password = ?";

			connection = openOracleConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setCpfNumber(resultSet.getString("cpf_number"));
				user.setName(resultSet.getString("name"));
			}

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection(connection, resultSet, callableStatement);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public boolean save(UserBean user, String newLogin, String newPassword) {
		return user.getId() > 0 ? update(user, newLogin, newPassword) : create(user);
	}

	public boolean create(UserBean user) {		
		int result = 0;
		
        try {
        	String sqlLogin = "INSERT INTO realm_users (user_email, password) VALUES (?, ?)";        	
        	
            connection = openOracleConnection();            
            
            preparedStatement = connection.prepareStatement(sqlLogin);            
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();            
		} finally {
			try {
				closeConnection(connection, resultSet, preparedStatement);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
        return result == 1;
	}

	public boolean update(UserBean user, String newLogin, String newPassword) {
		int result = 0;
		
        try {
        	String sqlLogin = "UPDATE realm_users SET user_email=?, password=? WHERE user_email=? and password=?";        	
        	
            connection = openOracleConnection();            
            
            preparedStatement = connection.prepareStatement(sqlLogin);            
            preparedStatement.setString(1, newLogin);
            preparedStatement.setString(2, newPassword);
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();            
		} finally {
			try {
				closeConnection(connection, resultSet, preparedStatement);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
        return result == 1;
	}

	public boolean remove(UserBean user) {
		int result = 0;
		
        try {
        	String sqlLogin = "DELETE FROM realm_users WHERE user_email=? and password=?";        	
        	
            connection = openOracleConnection();            
            
            preparedStatement = connection.prepareStatement(sqlLogin);            
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();            
		} finally {
			try {
				closeConnection(connection, resultSet, preparedStatement);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
        return result == 1;		
	}
}