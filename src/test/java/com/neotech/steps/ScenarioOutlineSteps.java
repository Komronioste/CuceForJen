package com.neotech.steps;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioOutlineSteps extends CommonMethods{
	
	@When("Login with {string} and {string}")
	public void login_with_and(String user, String pass) {
	    System.out.println("Login with --> " + user + " and --> " + pass);
	}
	@When("Click on login button")
	public void click_on_login_button() {
		System.out.println("Click");
	    
	}
	@Then("I validate that welcome {string} is displayed")
	public void i_validate_that_welcome_is_displayed(String userName) {
	   System.out.println("Validating Welcome --> " + userName);
	}
	@Then("We say bye {string}")
	public void we_say_bye(String name) {
		System.out.println("Bye bye, " + name);
	}

}
