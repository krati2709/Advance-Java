package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestMarksheetMeritList {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * , (physics + chemistry + maths + hindi + english) as total, "
				+ "((physics + chemistry + maths + hindi + english)/5) as percentage from marksheet order by total desc limit 0,5;");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1) + " " + "\t" + rs.getString(2) + " " + "\t" + rs.getInt(3) + " " + "\t" + 
					rs.getInt(4) + " " + "\t" + rs.getInt(5) + " " + "\t" + rs.getInt(6) + " " + "\t" +
					rs.getInt(7) + " " + "\t" + rs.getInt(8) + " " + "\t" + rs.getDouble(9));
			System.out.println();
		}
	}

}
