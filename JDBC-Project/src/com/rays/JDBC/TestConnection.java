package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from employee where id = 1");
		System.out.println("connection successful");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1) + " ");
			System.out.println();
			System.out.print(rs.getString(2) + " ");
		}
	}

}
