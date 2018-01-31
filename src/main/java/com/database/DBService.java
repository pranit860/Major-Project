package com.database;

import java.sql.*;

public class DBService {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/major_project";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "admin";
	   
	   public void db() {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	     // System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	     // System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      //System.out.println("Inserting records into the table...");
	     /* stmt = conn.createStatement();
	      
	      String sql = "INSERT INTO image_table (id) " +
	                  "VALUES (6)";
	      stmt.executeUpdate(sql);
	      
	      System.out.println("Inserted records into the table...");*/

	      
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	   }

}
