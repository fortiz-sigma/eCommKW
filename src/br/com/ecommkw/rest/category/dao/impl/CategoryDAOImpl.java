/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.category.dao.impl;

/*
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import br.com.ecommkw.rest.category.bean.CategoryBean;
import br.com.ecommkw.rest.category.dao.CategoryDAO;
import br.com.ecommkw.rest.dao.AbstractDAO;

/**
 * @author Francisco Eduardo Ortiz
 */

public class CategoryDAOImpl extends AbstractDAO implements CategoryDAO { 

	public List<CategoryBean> findAll() {
      	
        List<CategoryBean> categories = null;
    	
        try {        	
        	String sql = "SELECT * FROM category ORDER BY name";
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            categories = new ArrayList<CategoryBean>();            
            while (resultSet.next()) {
                categories.add(processRow(resultSet));
            }
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
        return categories;		
	}
    
    public CategoryBean findById(int id)  {
    	CategoryBean categories = null;

        try {
        	String sql = "SELECT * FROM category WHERE id = ?";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
                                    
            while (resultSet.next()) {
                categories = processRow(resultSet);
            }
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
        return categories;
    }
    
    public List<CategoryBean> findByName(String name) {
    	List<CategoryBean> categories = null;

        try {
        	String sql = "SELECT * FROM category as e " +
			"WHERE UPPER(name) LIKE ? " +	
			"ORDER BY name";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name.toUpperCase() + "%");
            resultSet = preparedStatement.executeQuery();
            
            categories = new ArrayList<CategoryBean>();            
            while (resultSet.next()) {
                categories.add(processRow(resultSet));
            }
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
        return categories;
    }
     
    public CategoryBean save(CategoryBean category) {
		return category.getId() > 0 ? update(category) : create(category);
	}        
    
    public CategoryBean create(CategoryBean category) {
        try {
        	String sql = "INSERT INTO category (name) VALUES (?)";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql, new String[] { "ID" });            
            preparedStatement.setString(1, category.getName());   
            preparedStatement.executeUpdate();          
            resultSet = preparedStatement.getGeneratedKeys();
            
            resultSet.next();      
            int id = resultSet.getInt(1);
            category.setId(id);
            
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
        return category;  	
    }

    public CategoryBean update(CategoryBean category) {
        try {        	
        	String sql = "UPDATE category SET name=? WHERE id=?";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getId());            
            preparedStatement.executeUpdate();
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
        return category;  	
    }    

    public boolean remove(int id) {
    	int count = 0;
    	
        try {
        	String sql = "DELETE FROM category WHERE id=?";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            count = preparedStatement.executeUpdate();            
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
		return count == 1;
    }    
    
    public CategoryBean processRow(ResultSet rs) throws SQLException {
        CategoryBean category = new CategoryBean();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        return category;
    }    
}