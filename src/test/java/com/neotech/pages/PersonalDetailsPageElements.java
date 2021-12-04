package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class PersonalDetailsPageElements extends CommonMethods {

	@FindBy(xpath = "//*[@id=\"pdMainContainer\"]/div[1]/h1")
	public WebElement personalDetailsHeader;

	@FindBy(xpath = "//*[@id=\"profile-pic\"]/h1")
	public WebElement nameHeader;

	@FindBy(xpath = "//*[@id='btnSave']")
	public WebElement personalDetailsEditButton;

	@FindBy(id = "personal_txtLicenNo")
	public WebElement licenseNumberTextBox;

	@FindBy(id = "personal_txtNICNo")
	public WebElement SSNTextBox;

	@FindBy(xpath = "//ul[@class='radio_list']/li/input")
	public WebElement genderMaleOption;

	@FindBy(xpath = "//ul[@class='radio_list']/li[2]/input")
	public WebElement genderFemaleOption;

	@FindBy(id = "personal_cmbNation")
	public WebElement nationalitySelectTab;

	@FindBy(id = "personal_txtLicExpDate")
	public WebElement LicenseExpiryTextBox;

	@FindBy(id = "btnSave")
	public WebElement saveButton;

	@FindBy(xpath = "//img[@class='ui-datepicker-trigger']")
	public WebElement calendarIcon;
	
	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	public WebElement calendarMonthSelect;
	
	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	public WebElement calendarYearSelect;
	
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
	public List<WebElement> calendarDays;
	
	

	public PersonalDetailsPageElements() {
		PageFactory.initElements(driver, this);
	}

}
