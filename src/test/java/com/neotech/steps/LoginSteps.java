package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {

//	@Given("I navigated to Orange HRM website")
//	public void i_navigated_to_orange_hrm_website() {
//
//		setUp();
//
//	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
		sendText(login.username, ConfigsReader.getProperty("username"));
	}

	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		click(login.loginBtn);
	}

	@Then("I validate that I am logged in")
	public void i_validate_that_i_am_logged_in() {

		String expectedText = "Welcome Paul";
		String actualText = dashboard.welcome.getText();

		if (actualText.equals(expectedText))
			System.out.println("Test passed");
		else
			System.out.println("Test Failed");

		wait(2);
	}

	@Then("I will quit the browser")
	public void i_will_quit_the_browser() {
		tearDown();
	}

	@When("I enter an invalid password")
	public void i_enter_an_invalid_password() {
		sendText(login.password, "asdfghj");
	}

	@Then("I validate that Invalid credentials message is displayed")
	public void i_validate_that_invalid_credentials_message_is_displayed() {
		String expectedText = "Invalid credentials";
		String actualText = login.errorMessage.getText();
		String result = (actualText.equals(expectedText)) ? "Negative Test Passed" : "Negative Test Failed";
		System.out.println(result);
	}

	@Given("user is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {

		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
	}

	@When("user enters username and password and clicks on login and verify by firstname")
	public void user_enters_and_and_clicks_on_login(DataTable dataTable) {

		List<Map<String, String>> credentials = dataTable.asMaps();

		for (Map<String, String> users : credentials) {
			String uname = users.get("username");
			String pword = users.get("password");
			String userFname = users.get("firstname");

			sendText(login.username, uname);
			sendText(login.password, pword);
			wait(1);
			click(login.loginBtn);

			String expectedText = "Welcome " + userFname;
			String actualText = dashboard.welcome.getText();
			wait(1);
			Assert.assertEquals("Names do NOT match", expectedText, actualText);

			click(dashboard.welcome);
			wait(1);
			click(dashboard.logoutButton);
		}

	}
}
