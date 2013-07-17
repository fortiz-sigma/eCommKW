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

import br.com.ecommkw.rest.customer.bean.UserGroupBean;
import br.com.ecommkw.rest.customer.dao.UserGroupDAO;
import br.com.ecommkw.rest.dao.AbstractDAO;

/**
 * @author Francisco Eduardo Ortiz
 */
public class UserGroupDAOImpl extends AbstractDAO implements UserGroupDAO {

    public boolean create(UserGroupBean userGroup) {
		int result = 0;
		
        try {
        	String sqlLogin = "INSERT INTO realm_users_roles (user_email, role_name) VALUES (?, ?)";        	
        	
            connection = openOracleConnection();            
            
            preparedStatement = connection.prepareStatement(sqlLogin);            
            preparedStatement.setString(1, userGroup.getLogin());
            preparedStatement.setString(2, userGroup.getGroup());
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

    public boolean remove(UserGroupBean userGroup) {
		int result = 0;
		
        try {
        	String sqlLogin = "DELETE FROM realm_users_roles WHERE user_email=? and role_name=?";        	
        	
            connection = openOracleConnection();            
            
            preparedStatement = connection.prepareStatement(sqlLogin);            
            preparedStatement.setString(1, userGroup.getLogin());
            preparedStatement.setString(2, userGroup.getGroup());
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
