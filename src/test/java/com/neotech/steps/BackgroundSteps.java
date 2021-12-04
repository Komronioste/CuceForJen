package com.neotech.steps;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundSteps extends CommonMethods{
	
	
	@Given("Precondition1")
	public void precondition1() {
	    System.out.println("Precondition number 1");
	}
	@Given("Precondition2")
	public void precondition2() {
		 System.out.println("Precondition number 2");
	}
	@When("Test step1")
	public void test_step1() {
		 System.out.println("Test number 1");
	}
	@When("Test step2")
	public void test_step2() {
		 System.out.println("Test number 2");
	}
	@When("Test step3")
	public void test_step3() {
		System.out.println("Test number 3");
	}
	@Then("Validation1")
	public void validation1() {
		System.out.println("Validation number 1");
	}
	@Then("Validation2")
	public void validation2() {
		System.out.println("Validation number 2");
	}
	
	@When("Test step4")
	public void test_step4() {
		 System.out.println("Test number 4");
	}
	@When("Test step5")
	public void test_step5() {
		 System.out.println("Test number 5");
	}
	@When("Test step6")
	public void test_step6() {
		 System.out.println("Test number 6");
	}
	@Then("Validation3")
	public void validation3() {
		 System.out.println("Validation number 3");
	}
	@Then("Validation4")
	public void validation4() {
		 System.out.println("Validation number 3");
	}
	@When("Test step1 firstname is {string} and lastname is {string}")
	public void test_step1_firstname_is_and_lastname_is(String firstName, String lastName) {
	    System.out.println("Running test step nr1 with firstname = " +firstName+ " and last name "+ lastName);
	}
	@When("Test step3 age is {int}")
	public void test_step3_age_is(Integer age) {
		System.out.println("Running test step nr1 with age = " + age);
	}
}
