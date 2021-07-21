package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionGenerator {
	// connection interface
	 static Connection connection;
	
	public static Connection createConnection() {
		
		try {
			// Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/student_manage";
			
			// Create the connection...
			connection = DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
