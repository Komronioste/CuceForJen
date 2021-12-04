package com.neotech.practiceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {

	
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
		ResultSet rs = st.executeQuery("SELECT * FROM book;");
		System.out.println("-----");
		
		//getting values from the ResultSet
		rs.next();
		String bookName1 = rs.getString("BookName");
		System.out.println(bookName1);
		
		//this line moves to the next row
		rs.next();
		String bookName2 = rs.getString(2); //getting column by it's index. in SQL indices start with 1, not 0 !!!
		System.out.println(bookName2);
		
		//next line, getting info as an Object
		rs.next();
		Object o = rs.getObject("BookName");
		System.out.println(o.toString());
		
		System.out.println("--------Printing values using while loop-----------");
		while(rs.next())
		{
			String bookName = rs.getObject("BookName").toString();
			System.out.println(bookName);
		}
		
	}

}
