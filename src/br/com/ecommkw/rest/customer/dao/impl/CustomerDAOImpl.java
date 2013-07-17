/*
 * Copyright (c) 2013, Sigma Virtual Design Ltda. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package br.com.ecommkw.rest.customer.dao.impl;

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

import br.com.ecommkw.rest.customer.bean.CustomerBean;
import br.com.ecommkw.rest.customer.dao.CustomerDAO;
import br.com.ecommkw.rest.dao.AbstractDAO;

/**
 * @author Francisco Eduardo Ortiz
 */

public class CustomerDAOImpl extends AbstractDAO implements CustomerDAO { 

	public List<CustomerBean> findAll() {
      	
        List<CustomerBean> customers = null;
    	
        try {        	
        	String sql = "SELECT * FROM customer ORDER BY name";
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            customers = new ArrayList<CustomerBean>();            
            while (resultSet.next()) {
                customers.add(processRow(resultSet));
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
        return customers;		
	}
    
    public CustomerBean findById(int id)  {
    	CustomerBean customers = null;

        try {
        	String sql = "SELECT * FROM customer WHERE id = ?";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
                                    
            while (resultSet.next()) {
                customers = processRow(resultSet);
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
        return customers;
    }
    
    public List<CustomerBean> findByName(String name) {
    	List<CustomerBean> customers = null;

        try {
        	String sql = "SELECT * FROM customer as e " +
			"WHERE UPPER(name) LIKE ? " +	
			"ORDER BY name";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name.toUpperCase() + "%");
            resultSet = preparedStatement.executeQuery();
            
            customers = new ArrayList<CustomerBean>();            
            while (resultSet.next()) {
                customers.add(processRow(resultSet));
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
        return customers;
    }
    
    public List<CustomerBean> findByEmail(String email) {
       	List<CustomerBean> customers = null;

        try {
        	String sql = "SELECT * FROM customer as e " +
			"WHERE UPPER(email) LIKE ? " +	
			"ORDER BY name";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + email.toUpperCase() + "%");
            resultSet = preparedStatement.executeQuery();
            
            customers = new ArrayList<CustomerBean>();            
            while (resultSet.next()) {
                customers.add(processRow(resultSet));
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
        return customers;
    }
    
    public List<CustomerBean> findByPhone(String phone)  {
       	List<CustomerBean> customers = null;

        try {
        	String sql = "SELECT * FROM customer as e " +
			"WHERE UPPER(phone) LIKE ? " +	
			"ORDER BY name";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + phone.toUpperCase() + "%");
            resultSet = preparedStatement.executeQuery();
            
            customers = new ArrayList<CustomerBean>();            
            while (resultSet.next()) {
                customers.add(processRow(resultSet));
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
        return customers;
    }    
    
    public List<CustomerBean> findByAddress(String address) {
       	List<CustomerBean> customers = null;

        try {
        	String sql = "SELECT * FROM customer as e " +
			"WHERE UPPER(address) LIKE ? " +	
			"ORDER BY name";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + address.toUpperCase() + "%");
            resultSet = preparedStatement.executeQuery();
            
            customers = new ArrayList<CustomerBean>();            
            while (resultSet.next()) {
                customers.add(processRow(resultSet));
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
        return customers;    	
    }

    public List<CustomerBean> findByCityRegion(String cityRegion) {
       	List<CustomerBean> customers = null;

        try {
        	String sql = "SELECT * FROM customer as e " +
			"WHERE UPPER(city_region) LIKE ? " +	
			"ORDER BY name";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + cityRegion.toUpperCase() + "%");
            resultSet = preparedStatement.executeQuery();
            
            customers = new ArrayList<CustomerBean>();            
            while (resultSet.next()) {
                customers.add(processRow(resultSet));
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
        return customers;    	
    }
    
    public List<CustomerBean> findByCpfNumber(String cpfNumber) {
       	List<CustomerBean> customers = null;

        try {
        	String sql = "SELECT * FROM customer as e " +
			"WHERE UPPER(cpf_Number) LIKE ? " +	
			"ORDER BY name";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + cpfNumber.toUpperCase() + "%");
            resultSet = preparedStatement.executeQuery();
            
            customers = new ArrayList<CustomerBean>();            
            while (resultSet.next()) {
                customers.add(processRow(resultSet));
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
        return customers;    	
    }
    
    public CustomerBean save(CustomerBean customer) {
		return customer.getId() > 0 ? update(customer) : create(customer);
	}        
    
    public CustomerBean create(CustomerBean customer) {
        try {
        	String sql = "INSERT INTO customer (name, email, phone, address, city_region, cpf_Number, password) VALUES (?, ?, ?, ?, ?, ?, ?)";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql, new String[] { "ID" });            
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getCityRegion());
            preparedStatement.setString(6, customer.getCpfNumber());
            preparedStatement.setString(7, customer.getPassword());
            preparedStatement.executeUpdate();          
            resultSet = preparedStatement.getGeneratedKeys();
            
            resultSet.next();      
            int id = resultSet.getInt(1);
            customer.setId(id);
            
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
        return customer;  	
    }

    public CustomerBean update(CustomerBean customer) {
        try {        	
        	String sql = "UPDATE customer SET name=?, email=?, phone=?, address=?, city_region=?, cpf_number=?, password=? WHERE id=?";        	
        	
            connection = openOracleConnection();            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getCityRegion());
            preparedStatement.setString(6, customer.getCpfNumber());
            preparedStatement.setString(7, customer.getPassword());            
            preparedStatement.setInt(8, customer.getId());            
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
        return customer;  	
    }    

    public boolean remove(int id) {
    	int count = 0;
    	
        try {
        	String sql = "DELETE FROM customer WHERE id=?";        	
        	
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
    
    public CustomerBean processRow(ResultSet rs) throws SQLException {
        CustomerBean customer = new CustomerBean();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setEmail(rs.getString("email"));
        customer.setPhone(rs.getString("phone"));
        customer.setAddress(rs.getString("address"));
        customer.setCityRegion(rs.getString("city_region"));
        customer.setCpfNumber(rs.getString("cpf_number"));
        customer.setPassword(rs.getString("password"));
        return customer;
    }    
}