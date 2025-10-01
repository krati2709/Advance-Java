package com.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//step 1: make class final
public class JDBCDataSource {

//Step 2: Make the self variable private and static, 
	// because a static variable in a final class can only have one copy during the
	// program's lifetime."
	private static JDBCDataSource datasource = null;
	private static ComboPooledDataSource cpds = null;

//step 3: make the default constructor private so no other class can create instance of it
	private JDBCDataSource() {
	}

//step 4: create method getInstance and return type should be name of class. and return instance of class
	private static JDBCDataSource getInstance() {

		if (datasource == null) {
			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();

			ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

			try {
				datasource.cpds.setDriverClass(rb.getString("driver"));
				datasource.cpds.setJdbcUrl(rb.getString("url"));
				datasource.cpds.setUser(rb.getString("username"));
				datasource.cpds.setPassword(rb.getString("password"));
				datasource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
				datasource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialPoolSize")));
				datasource.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxPoolSize")));
				datasource.cpds.setMinPoolSize(Integer.parseInt(rb.getString("minPoolSize")));

			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return datasource;
	}

	public static Connection getConnection() throws SQLException {
		return getInstance().cpds.getConnection();
	}

	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
	
	public static void trnRollback(Connection conn) throws SQLException {
		if (conn != null) {
			conn.rollback();
		}
	}

}
