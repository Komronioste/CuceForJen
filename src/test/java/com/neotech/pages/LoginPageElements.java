package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.neotech.utils.CommonMethods;

public class LoginPageElements extends CommonMethods {

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(name = "txtPassword")
	public WebElement password;

	@FindBy(css = "input#btnLogin")
	public WebElement loginBtn;

	@FindBy(id = "spanMessage")
	public WebElement errorMessage;

	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}

}
