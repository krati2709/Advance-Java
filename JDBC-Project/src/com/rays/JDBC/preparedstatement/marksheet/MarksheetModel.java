package com.rays.jdbc.preparedstatement.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MarksheetModel {
	
	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
	String url = rb.getString("url");
	String driver = rb.getString("driver");
	String password = rb.getString("password");
	String username = rb.getString("username");
	
	
	//next Pk method
	public int nextPk() throws Exception {
		int pk = 0;
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = conn.prepareStatement("select max(rollNo) from marksheet");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}
	
	
	//add method
	
	public void add(MarksheetBean bean) throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?");
		
		int pk = nextPk();
		pstmt.setInt(1, pk);
		
		
		
		
		
	}

}
