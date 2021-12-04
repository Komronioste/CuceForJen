package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods {

	@FindBy(id = "firstName")
	public WebElement firstNameTextBox;

	@FindBy(id = "lastName")
	public WebElement lastNameTextBox;

	@FindBy(id = "middleName")
	public WebElement middleNameTextBox;

	@FindBy(id = "employeeId")
	public WebElement employeeIdTextBox;

	@FindBy(id = "photofile")
	public WebElement photoButton;

	@FindBy(id = "btnSave")
	public WebElement saveButton;

	@FindBy(id = "chkLogin")
	public WebElement loginDetailsCheckBox;

	@FindBy(id = "user_name")
	public WebElement usernameTextBox;

	@FindBy(id = "user_password")
	public WebElement passwordTextBox;

	@FindBy(id = "re_password")
	public WebElement confirmPasswordTextBox;

	@FindBy(xpath = "//*[@id='pdMainContainer']/div[1]/h1")
	public WebElement personalDetailsTxt;
	
	@FindBy(xpath = "//*[@id='content']/div/div[1]/h1")
	public WebElement header;

	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);

	}

}
