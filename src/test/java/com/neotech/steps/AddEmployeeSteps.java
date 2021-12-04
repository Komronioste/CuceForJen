package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods {

	@Given("user navigates to PIM page")
	public void user_navigates_to_pim_page() {
		click(dashboard.PIM);
	}

	@Given("user navigates to add employee page")
	public void user_navigates_to_add_employee_page() {
		click(dashboard.PIM);
		click(employeeList.addButton);
	}

	@When("user enters first name")
	public void user_enters_first_name() {

		sendText(addEmployee.firstNameTextBox, "Gerard");
	}

	@When("user enters last name")
	public void user_enters_last_name() {
		sendText(addEmployee.lastNameTextBox, "Pique");
	}

	@When("user saves the information")
	public void user_saves_the_information() {
		click(addEmployee.saveButton);
	}

	@Then("new employee page is displayed")
	public void new_employee_page_is_displayed() {
		String expectedText = "Personal Details";
		String actualText = personalDetails.personalDetailsHeader.getText();

		String assertion = (actualText.equals(expectedText)) ? "Employee has been ADDED" : "Employe has NOT been ADDED";
		System.out.println(assertion);
		wait(2);

	}

	@When("user deletes default employee id")
	public void user_deletes_default_employee_id() {
		addEmployee.employeeIdTextBox.clear();
	}

	@When("user click on Create Login Credentials button")
	public void user_click_on_create_login_credentials_button() {
		click(addEmployee.loginDetailsCheckBox);
	}

	@When("user enters new username")
	public void user_enters_new_username() {
		sendText(addEmployee.usernameTextBox, "GerardP");
	}

	@When("user enters new password")
	public void user_enters_new_password() {
		sendText(addEmployee.passwordTextBox, "Gera82BarCa!!");
	}

	@When("user confirm new password")
	public void user_confirm_new_password() {
		sendText(addEmployee.confirmPasswordTextBox, "Gera82BarCa!!");
	}

//	@Then("validate that employee is added successfully")
//	public void validate_that_employee_is_added_successfully() {
//	    
//	}
	@Then("validate that {string} is added successfully")
	public void validate_that_is_added_successfully(String fullName) {

		String expectedText = fullName;
		String actualText = personalDetails.nameHeader.getText();

		String result = (actualText.equals(expectedText)) ? "Test Passed, Good job" : "Test Failed, try again";
		System.out.println(result);
		Assert.assertEquals("The name does not match", expectedText, actualText);
		wait(2);
	}

	@When("user enters first name {string}")
	public void user_enters_first_name(String firstName) {
		sendText(addEmployee.firstNameTextBox, firstName);
		wait(1);
	}

	@When("user enters lastname {string}")
	public void user_enters_lastname(String lastName) {
		sendText(addEmployee.lastNameTextBox, lastName);
		wait(1);
	}

	@When("user enters employee {string}, {string} and {string}")
	public void user_enters_employee_and(String fn, String mn, String ln) {
		sendText(addEmployee.firstNameTextBox, fn);
		sendText(addEmployee.middleNameTextBox, mn);
		sendText(addEmployee.lastNameTextBox, ln);
	}

	@Then("validate that {string}, {string} and {string} is added successfully")
	public void validate_that_and_is_added_successfully(String fn, String mn, String ln) {

		String expectedText = fn + " " + mn + " " + ln;
		String actualText = personalDetails.nameHeader.getText();

		Assert.assertEquals("The names do not match!", expectedText, actualText);
	}

	@When("user enters employee details")
	public void user_enters_employee_details(DataTable dataTable) {
		System.out.println(dataTable);
		// we have a list of maps {map1, map2, ...}
		List<Map<String, String>> empList = dataTable.asMaps();
		for (Map<String, String> employee : empList) {
			System.out.println(employee);
			String fName = employee.get("FirstName");
			String mName = employee.get("MiddleName");
			String lName = employee.get("LastName");

			sendText(addEmployee.firstNameTextBox, fName);
			sendText(addEmployee.middleNameTextBox, mName);
			sendText(addEmployee.lastNameTextBox, lName);
			click(addEmployee.saveButton);

			String expectedText = fName + " " + mName + " " + lName;
			String actualText = personalDetails.nameHeader.getText();

			Assert.assertEquals("The names do not match!", expectedText, actualText);

			// before next iteration, we need to go back to Add Employee Page***
			wait(1);
			jsClick(dashboard.addEmployeeButton);
			wait(1);
		}

	}

	@When("user enters login info {string} and {string}")
	public void user_enters_login_info_and(String userName, String password) {
		sendText(login.username, userName);
		sendText(login.password, password);
		wait(2);
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		click(login.loginBtn);
	}

	@Then("Welcome {string} message is displayed")
	public void welcome_message_is_displayed(String name) {
		wait(2);
		String expectedText = "Welcome " + name;
		String actualText = dashboard.welcome.getText();

		Assert.assertEquals("Names do NOT match", expectedText, actualText);

	}

	@When("user enters employee {string} with lastname {string}")
	public void user_enters_employee_with_lastname(String firstName, String lastName) {
		sendText(addEmployee.firstNameTextBox, firstName);
		sendText(addEmployee.lastNameTextBox, lastName);
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
		click(addEmployee.saveButton);
	}

	@When("I click on Personal Details Edit")
	public void i_click_on_personal_details_edit() {
		click(personalDetails.personalDetailsEditButton);
		wait(1);
	}

	@Then("I am able to modify Employee Details {string}, {string}, {string}, {string}, {string}")
	public void i_am_able_to_modify_employee_details(String driverLicense, String expiration, String SSN, String gender,
			String nationality) {

		// driver's license
		sendText(personalDetails.licenseNumberTextBox, driverLicense);
		// SSN
		sendText(personalDetails.SSNTextBox, SSN);
		// Gender
		if (gender.equals("Male"))
			click(personalDetails.genderMaleOption);
		else
			click(personalDetails.genderFemaleOption);
		wait(2);
		// Nationality
		Select select = new Select(personalDetails.nationalitySelectTab);
		select.selectByVisibleText(nationality);

		// License expiry
		sendText(personalDetails.LicenseExpiryTextBox, expiration);
		wait(2);
	}

	@Then("I click on Personal Details Save")
	public void i_click_on_personal_details_save() {

		click(personalDetails.saveButton);

	}
	
	@When("user enters employee data from {string} excel sheet then save")
	public void user_enters_employee_data_from_excel_sheet_then_save(String sheetName) {
		
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/Excel.xlsx";
		
	   List<Map<String,String>> excelList = ExcelUtility.excelIntoListOfMaps(path, sheetName);
	   
	  	for (Map<String,String> dataMap : excelList)
	  	{
	  		String fName = dataMap.get("FirstName");
	  		String lName = dataMap.get("LastName");
	  		String user = dataMap.get("Username");
	  		String pass = dataMap.get("Password");
	  		
	  		System.out.println(fName + " " + lName + " " + user + " " + pass);
	  		
	  		sendText(addEmployee.firstNameTextBox, fName);
	  		sendText(addEmployee.lastNameTextBox, lName);
	  		click(addEmployee.loginDetailsCheckBox);
	  		sendText(addEmployee.usernameTextBox, user);
	  		sendText(addEmployee.passwordTextBox, pass);
	  		sendText(addEmployee.confirmPasswordTextBox , pass);
	  		click(addEmployee.saveButton);
	  		
	  		//Assertion
	  		
	  		String expectedText = fName + " " + lName;
			String actualText = personalDetails.nameHeader.getText();

			Assert.assertEquals("Employee is not ADDED", expectedText, actualText);

			// before next iteration, we need to go back to Add Employee Page***
			wait(1);
			jsClick(dashboard.addEmployeeButton);
			wait(1);
	  		
	  	}
	}
	
	@Then("I am able to modify Employee Details  {string}")
	public void i_am_able_to_modify_employee_details(String string) {
	   
		click(personalDetails.calendarIcon);
		Select selYear = new Select(personalDetails.calendarYearSelect);
		selYear.selectByVisibleText("2022");
		
		Select selMonth = new Select(personalDetails.calendarMonthSelect);
		selMonth.selectByVisibleText("Feb");
		
		List<WebElement> days = personalDetails.calendarDays; 
		
		for(WebElement i : days)
		{
			if(i.getText().equals("5"))
			{
				wait(1);
				i.click();
				wait(1);
			}
		}
		
		
	}

}
