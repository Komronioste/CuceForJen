package com.neotech.practiceDB;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.neotech.utils.DBUtils;

public class StoringDataUtils {

	
	
	@Test
	public void getDataFromDB() throws SQLException {
		DBUtils.getConnection();
		
		
		List<Map<String, String>> listData = DBUtils.storeDataFromDB("SELECT employeeNumber, email FROM employees LIMIT 5");
		
		System.out.println(listData);
		
		DBUtils.closeConnection();
	}
}
