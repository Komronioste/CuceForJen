package com.neotech.practiceDB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


public class MetaDataDemo {


	public static String dbUserName = "signalt_user1";
	public static String dbPassword = "trpass@2020";
	// jdbc : mySQL 				jdbc : mysql    hostname  port	database name
	public static String dbUrl = "jdbc:mysql://66.113.163.71:3306/signalt_classicmodels";
	
	
	public static void main(String[] args) throws SQLException {
	
		//Creating connection to database
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		DatabaseMetaData dbMetaData = conn.getMetaData();
		
		String driverName = dbMetaData.getDriverName();
		System.out.println(driverName);
		
		String dbVersion = dbMetaData.getDatabaseProductVersion();
		System.out.println(dbVersion);
		
		String dbName = dbMetaData.getDatabaseProductName();
		System.out.println(dbName);
		
		

	}
	
	@Test
	public void rsMetaData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM employees WHERE employeeNumber = 1076");
		
		//Get information about ResultSet
		ResultSetMetaData rsMetaData = rs.getMetaData();
		
		//Get number of columns in the resultset
		int columnCount = rsMetaData.getColumnCount();
		System.out.println("number of columns " + columnCount);
		
		String columnName1 = rsMetaData.getColumnName(1);
		System.out.println("columnName1 = " + columnName1);
		
		String columnName4 = rsMetaData.getColumnName(4);
		System.out.println("columnName4 = " + columnName4);
		
		
		System.out.println("---Printing all column names using a for loop---");
		
		for(int i=1; i <= columnCount; i++)
		{
			String columnName = rsMetaData.getColumnName(i);
			System.out.println( columnName);
		}
		
		System.out.println("---Printing all column types using a for loop---");
		
		for(int i=1; i <= columnCount; i++)
		{
			String columnName = rsMetaData.getColumnName(i);
			String columnType = rsMetaData.getColumnTypeName(i);
			System.out.println( columnName + " " + columnType);
		}
	}

}
