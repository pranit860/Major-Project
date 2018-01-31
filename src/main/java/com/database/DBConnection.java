package com.database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {
	 
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	   static final String USER = "root";
	   static final String PASS = "pranit";
	   private Connection conn;
	  
	   public Connection connect()
	   {
		   try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		   try {
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		  return conn;
	   }
	   
}
