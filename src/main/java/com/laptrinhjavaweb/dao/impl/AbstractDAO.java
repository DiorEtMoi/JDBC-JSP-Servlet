package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Timestamp;
import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T>{
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jspservletjdbc";
			String user = "root";
			String password = "thaihoan12";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException  | SQLException e) {
			// TODO: handle exception
			return null;
		} 
		
	}

	@Override
	public List<T> query(String sql, RowMapper<T> mapper, Object... paramters) {
		List<T> results = new ArrayList<>();
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			//set parameters
			setParameter(statement, paramters);
			resultset = statement.executeQuery();
			while(resultset.next()) {
				results.add(mapper.mapRow(resultset));
			}
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(resultset != null) {
				resultset.close();
			}
			return results;
			
		} catch (SQLException e) {
			// TODO: handle exception
			return null;
			
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultset != null) {
					resultset.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				return null;
			}
		}
		
	}
	private void setParameter(PreparedStatement statement,Object... parameters) {
		try {
			for(int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if(parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String)parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer)parameter);
				} 
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			//set parameters
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//set parameters
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
			rs = statement.getGeneratedKeys();
			if(rs.next()) {
				return rs.getLong(1);
			}
			return null;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
				return null;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
		}
	}

	@Override
	public int count(String sql, Object... parameters) {
		int count = 0;
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			//set parameters
			setParameter(statement, parameters);
			resultset = statement.executeQuery();
			while(resultset.next()) {
				count = resultset.getInt(1);
			}
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(resultset != null) {
				resultset.close();
			}
			return count;
			
		} catch (SQLException e) {
			// TODO: handle exception
			return count;
			
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultset != null) {
					resultset.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				return count;
			}
		}
	}
}
