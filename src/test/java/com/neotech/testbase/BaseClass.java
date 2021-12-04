package com.neotech.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

public class BaseClass {

	public static WebDriver driver;

	public static WebElement x(String path) {
		return driver.findElement(By.xpath(path));
	}

	/**
	 * this method will create the driver and return it
	 * 
	 * @return WebDriver driver
	 */

	public static WebDriver setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		if (ConfigsReader.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();

//		System.out.println(" I want to open chrome browser");
		} else if (ConfigsReader.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();

			System.out.println(" I want to open firefox browser");
		}

		driver.get(ConfigsReader.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		PageInitializer.initialize();
		
		return driver;

	}

	/** 
	 * this method will close the browser
	 */
	public static void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
