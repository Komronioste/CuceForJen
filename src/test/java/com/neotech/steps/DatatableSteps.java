package com.neotech.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatatableSteps {
	
	@When("I login to HRMS")
	public void i_login_to_hrms() {
	    System.out.println("Login");
	}
	@When("I want to add employees")
	public void i_want_to_add_employees(DataTable dataTable) {
		
		//How a list of maps is created
//		Map<String, String> map1 = new HashedMap<>();
//		map1.put("FN", "Shodmon");
//		map1.put("LN", "Baba");
//		
//		Map<String, String> map2 = new HashedMap<>();
//		map2.put("FN", "Enes");
//		map2.put("LN", "Safran");
//		
//		List<Map<String,String>> lm = new ArrayList<>();
//		lm.add(map1);
//		lm.add(map2);
		
		//this will convert the dataTable into a List of Maps
	  List<Map<String,String>> listOfMaps = dataTable.asMaps();
	  
	  for (Map<String,String> map : listOfMaps)
	  {
//		  System.out.println(map);
		  System.out.println("---------------------------------------");
		  System.out.println("FirstName = " + map.get("FirstName"));
		  System.out.println("MiddleName = " + map.get("MiddleName"));
		  System.out.println("LastName = " + map.get("LastName"));
		  System.out.println("DONE WITH THE TABLE------------------");
	  }
	  
	  
	}
	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	   System.out.println("Validating");
	}


}
