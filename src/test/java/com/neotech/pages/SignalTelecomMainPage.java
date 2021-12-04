package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class SignalTelecomMainPage extends CommonMethods{
	
	@FindBy(linkText = "Sign In")
	public WebElement signInLink;
	
	
	public SignalTelecomMainPage()
	{
		PageFactory.initElements(driver, this);
	}

}
