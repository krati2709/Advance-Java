package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	public static void main(String[] args) throws Exception {
		
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
	    
	    Statement stmt = conn.createStatement();
	    
	    int i = stmt.executeUpdate("delete from employee where id = 26");
	    System.out.println(i);
	    
	}

}
