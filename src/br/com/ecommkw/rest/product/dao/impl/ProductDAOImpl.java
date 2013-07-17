/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.product.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import br.com.ecommkw.rest.dao.AbstractDAO;
import br.com.ecommkw.rest.product.bean.ProductBean;
import br.com.ecommkw.rest.product.dao.ProductDAO;

/**
 * @author Francisco Eduardo Ortiz
 */
public class ProductDAOImpl extends AbstractDAO implements ProductDAO {   

	public List<ProductBean> findAll() {
        List<ProductBean> products = null;
    	
        try {        	
        	String sql = "SELECT * FROM product ORDER BY name";
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            products = new ArrayList<ProductBean>();            
            while (resultSet.next()) {
                products.add(processRow(resultSet));
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
        return products;
	}
    
    public ProductBean findById(int id) {
    	ProductBean products = null;

        try {
        	String sql = "SELECT * FROM product WHERE id = ?";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
                                    
            while (resultSet.next()) {
                products = processRow(resultSet);
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
        return products;
    }
    
    
    public List<ProductBean> findByName(String name) {
    	List<ProductBean> products = null;

        try {
        	String sql = "SELECT * FROM product as e " +
			"WHERE UPPER(name) LIKE ? " +	
			"ORDER BY name";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name.toUpperCase() + "%");
            resultSet = preparedStatement.executeQuery();
            
            products = new ArrayList<ProductBean>();            
            while (resultSet.next()) {
                products.add(processRow(resultSet));
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
        return products;
    }
    
    public List<ProductBean> findByPrice(Double price) {
    	List<ProductBean> products = null;
        
        try {
        	String sql = "SELECT * FROM product WHERE price = ?";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, price);
            resultSet = preparedStatement.executeQuery();
            
            products = new ArrayList<ProductBean>();            
            while (resultSet.next()) {
                products.add(processRow(resultSet));
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
        return products;        
    }
    
    public ProductBean save(ProductBean product) {
    	return product.getId() > 0 ? update(product) : create(product);    
    }
    
    public ProductBean create(ProductBean product) {
        try {
        	String sql = "INSERT INTO product (name, price, description, picture, category_id) VALUES (?, ?, ?, ?, ?, ?)";
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql, new String[] { "ID" });            
            preparedStatement.setString(1, product.getName());   
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getPicture());
            preparedStatement.setInt(5, product.getCategory_id());
            preparedStatement.executeUpdate();          
            resultSet = preparedStatement.getGeneratedKeys();
            
            resultSet.next();      
            int id = resultSet.getInt(1);
            product.setId(id);
            
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
        return product;
    }

    public ProductBean update(ProductBean product) {
        try {        	
        	String sql = "UPDATE product SET name=?, price=?, description=?, picture=?, category_id=? WHERE id=?";
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());   
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getPicture());
            preparedStatement.setInt(5, product.getCategory_id());
            preparedStatement.setInt(6, product.getId());            
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
        return product;  	
    }

    public boolean remove(int id) {
    	int count = 0;
    	
        try {
        	String sql = "DELETE FROM product WHERE id=?";        	
        	
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
    
    public ProductBean processRow(ResultSet rs) throws SQLException {
        ProductBean product = new ProductBean();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        product.setDescription(rs.getString("description"));
        product.setPicture(rs.getString("picture"));
        product.setCategory_id(rs.getInt("category_id"));

        return product;    	
    }
}