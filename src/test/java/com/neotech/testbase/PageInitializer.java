package com.neotech.testbase;

import com.neotech.pages.AddEmployeePageElements;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.EmployeeListPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.pages.PersonalDetailsPageElements;
import com.neotech.pages.SignalTelecomLoginPage;
import com.neotech.pages.SignalTelecomMainPage;

public class PageInitializer extends BaseClass{
	
	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static AddEmployeePageElements addEmployee;
	public static PersonalDetailsPageElements personalDetails;
	public static EmployeeListPageElements employeeList;
	
	// SignalTelecom Pages
	public static SignalTelecomMainPage signalMain;
	public static SignalTelecomLoginPage signalSignIn;
	
	public static void initialize()
	{
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		addEmployee = new AddEmployeePageElements();
		personalDetails = new PersonalDetailsPageElements();
		employeeList = new EmployeeListPageElements();
		
		//initialize 
		signalMain = new SignalTelecomMainPage();
		signalSignIn = new SignalTelecomLoginPage();
	}

}
