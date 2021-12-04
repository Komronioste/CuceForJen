package com.neotech.practiceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Homework01 {

	public static String dbUserName = "signalt_user1";
	public static String dbPassword = "trpass@2020";

	public static String dbUrl = "jdbc:mysql://66.113.163.71:3306/signalt_classicmodels";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM customers WHERE customerNumber < 124");

		ResultSetMetaData rsMetaData = rs.getMetaData();

		int columnCount = rsMetaData.getColumnCount();
		System.out.println("number of columns " + columnCount);

		LinkedHashMap<String, String> map = new LinkedHashMap<>();

		rs.next();
		for (int i = 1; i <= columnCount; i++) {
			
			String columnName = rsMetaData.getColumnName(i);
			String info = rs.getString(columnName);

			map.put(columnName, info);
			
		}

		for (Entry<String, String> i : map.entrySet()) {
			System.out.println(i.getKey() + ": " + i.getValue());
		}

	}

}
