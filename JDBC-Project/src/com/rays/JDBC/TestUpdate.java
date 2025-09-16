package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("update employee set salary = 75000 where id = 25");
		System.out.println(i);
	}

}
