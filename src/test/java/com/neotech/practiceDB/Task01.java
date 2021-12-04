package com.neotech.practiceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Task01 {
	
	
	public static String dbUserName = "signalt_user1";
	public static String dbPassword = "trpass@2020";
	// jdbc : mySQL 				jdbc : mysql    hostname  port	database name
	public static String dbUrl = "jdbc:mysql://66.113.163.71:3306/signalt_LibraryMgmt";
	
	
	
	public static void main(String[] args) throws SQLException {
		
		//Creating connection to database
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		
		System.out.println("Database connected!");
		
		//Creating a statement
		Statement st = conn.createStatement();
		
		//Executing a Query
		ResultSet rs = st.executeQuery("SELECT * FROM bookcategory;");
		System.out.println("-----");
		
		//getting values from the ResultSet
		
		ArrayList<String> list = new ArrayList<>();
		
		System.out.println("--------Printing values using while loop-----------");
		while(rs.next())
		{
			
			String bookName = rs.getObject("BookCategoryName").toString();
			list.add(bookName);
			
		}
		
		System.out.println(list);
		
		rs.close();
		st.close();
		conn.close();
		
	}

}
