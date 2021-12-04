package com.neotech.utils;

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

public class DBUtils {

	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;

	public static void getConnection() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		try {
			conn = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"),
					ConfigsReader.getProperty("dbUserName"), ConfigsReader.getProperty("dbPassword"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static List<Map<String, String>> storeDataFromDB(String sqlQuery) throws SQLException {

		st = conn.createStatement();
		rs = st.executeQuery(sqlQuery);
		ResultSetMetaData rsMD = rs.getMetaData();

		List<Map<String, String>> listData = new ArrayList<>();

		while (rs.next()) { // iterating the rows

			Map<String, String> mapData = new LinkedHashMap<>();

			for (int i = 1; i <= rsMD.getColumnCount(); i++) {

				mapData.put(rsMD.getColumnName(i), rs.getString(i));
			}

			listData.add(mapData);

		}

		return listData;

	}

	public static void closeConnection() {

		try {
			if ( (rs != null))
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
