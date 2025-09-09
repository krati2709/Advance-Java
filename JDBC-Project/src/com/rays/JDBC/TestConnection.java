package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//step1. load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step2. create connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
		//step3 create statement
		Statement stmt = conn.createStatement();
		
		//step4 execute query
		ResultSet rs = stmt.executeQuery("select * from employee");
		System.out.println("connection successful");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1) + " ");
			System.out.print("\t" +rs.getString(2) + " ");
			System.out.println();
		}
	}

}
