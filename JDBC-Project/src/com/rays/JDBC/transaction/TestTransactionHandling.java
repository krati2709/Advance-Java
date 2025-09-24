package com.rays.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionHandling {
	public static void main(String[] args) throws Exception {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			
			conn.setAutoCommit(false);
			
			Statement stmt = conn.createStatement();
			
			int i = stmt.executeUpdate("insert into marksheet values(27, 'mihir', 67, 89, 76, 87, 98)");
			i = stmt.executeUpdate("insert into marksheet values(28, 'mihir', 67, 89, 76, 87, 98)");
			i = stmt.executeUpdate("insert into marksheet values(29,'mihir', 67, 89, 76, 87, 98)");
			
			conn.commit();
			System.out.println("data is commited: " + 1);
			
		} catch (Exception e) {
			conn.rollback();
			System.out.println("data reverted");
			System.out.println(e.getMessage());
			
		}
	}

}
