package com.neotech.steps;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SignalTelecomSteps extends CommonMethods{
	
	
	@Given("User goes to Sign In page")
	public void user_goes_to_sign_in_page() {
	   signalMain.signInLink.click();
	   
	}
	@When("User enters invalid email")
	public void user_enters_invalid_email() {
	   sendText(signalSignIn.email, "something@gmail.com");
	}
	@When("User enters an invalid password")
	public void user_enters_an_invalid_password() {
	    sendText(signalSignIn.password, "mufasaIsTheBest@123");
	}
	@When("User clicks on Sign In button")
	public void user_clicks_on_sign_in_button() {
	    click(signalSignIn.signInBtn);
	}
	@Then("User sees an error message")
	public void user_sees_an_error_message() {
	    System.out.println("error message");
	}
	
	@When("User leaves empty email")
	public void user_leaves_empty_email() {
	   
	}

	@When("User enters an invalid email as {string}")
	public void user_enters_an_invalid_email_as(String string) {
	    sendText(signalSignIn.email, string);
	   
	}

	@When("User enters an invalid password as {string}")
	public void user_enters_an_invalid_password_as(String string) {
	    sendText(signalSignIn.password, string);
	}
	
	{Assert.assertEquals(true, false);}


}
