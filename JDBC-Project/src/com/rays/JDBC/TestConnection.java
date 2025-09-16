package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//step 1. load driver
		//class = class(java.lang) ; .forname method = class loader
		//com.mysql.cj.jdbc = package ; Driver = class
		//driver must be in class path
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//step 2. make connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
		
		//step 3. create statement
		Statement stmt = conn.createStatement();
		
		
		//step 4. execute Query and get result set or int
		ResultSet rs = stmt.executeQuery("select * from marksheet");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getInt(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.print("\t" + rs.getInt(6));
			System.out.println("\t" + rs.getInt(7));
			
			conn.close();
		}
	}

}

