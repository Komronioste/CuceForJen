package com.neotech.practiceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

public class StoringData {

	@Test
	public void getAndStoreData() throws SQLException {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		Connection conn = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"),
				ConfigsReader.getProperty("dbUserName"), ConfigsReader.getProperty("dbPassword"));

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(
				"SELECT employeeNumber, lastName, firstName, email FROM signalt_classicmodels.employees LIMIT 5");

		List<Map<String, String>> listOfMaps = new ArrayList<>();

		while (rs.next())

		{
			Map<String, String> map = new LinkedHashMap<>();
			map.put("Employee Number", rs.getObject("employeeNumber").toString());
			map.put("Last Name", rs.getString("lastName"));
			map.put("First Name", rs.getString("firstName"));
			map.put("Email", rs.getString("email"));

			listOfMaps.add(map);
		}
		System.out.println(listOfMaps);
		rs.close();
		st.close();
		conn.close();
	}

	@Test
	public void retrieveAndStoreEnhanced() throws SQLException {

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		Connection conn = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"),
				ConfigsReader.getProperty("dbUserName"), ConfigsReader.getProperty("dbPassword"));

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(
				"SELECT customerNumber, contactLastName, creditLimit FROM customers WHERE customerNumber < 130");

		ResultSetMetaData rsMD = rs.getMetaData();
		int colCount = rsMD.getColumnCount();

		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;

		while (rs.next()) { // iterating the rows

			map = new LinkedHashMap<>();

			for (int i = 1; i <= colCount; i++) {

				map.put(rsMD.getColumnName(i), rs.getString(i));
			}
			System.out.println(map);
			list.add(map);

		}

		System.out.println(list);
	}
}
