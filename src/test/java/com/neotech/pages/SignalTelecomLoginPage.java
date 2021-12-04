package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class SignalTelecomLoginPage extends CommonMethods{
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "pass")
	public WebElement password;
	
	@FindBy(id = "send2")
	public WebElement signInBtn;
	
	@FindBy(xpath = "//*[@id='maincontent']/div[2]/div[2]/div/div/div")
	public WebElement errorMessage;
	
	public SignalTelecomLoginPage()
	{
		PageFactory.initElements(driver, this);
	}

}
