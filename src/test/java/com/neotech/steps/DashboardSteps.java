package com.neotech.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;


public class DashboardSteps extends CommonMethods{
	
	@Then("I want to see this items in the menu")
	public void i_want_to_see_this_items_in_the_menu(DataTable dataTable) {

		System.out.println(dataTable);
		
		List<String> expectedList = dataTable.asList();
		
		List<WebElement> menu = dashboard.menuList;
		
		// I will iterate the WebElements and get the text
		List<String> actualList = new ArrayList<>();
	
		for(WebElement element : menu)
		{
			actualList.add(element.getText());
		}
		Assert.assertEquals(actualList, expectedList);
		
		System.out.println(actualList);
	}

}
