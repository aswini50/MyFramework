package com.learnautomation.framework.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.framework.base.BaseClass;
import com.learnautomation.framework.helper.DataGenerator;
import com.learnautomation.framework.pages.AdminPage;
import com.learnautomation.framework.pages.EmployeePage;
import com.learnautomation.framework.pages.LeavePage;
import com.learnautomation.framework.pages.LoginPage;
import com.learnautomation.framework.pages.Signout;

public class ApplyLeaveTest extends BaseClass {

	// Create Page Objects : Create an instance of Page Classes 
		LoginPage login ;
		AdminPage admin ;
		LeavePage leave;
		Signout signout ;
		public WebDriver driver;
		
	// Before Test : Instantiate Page Objects 
		@BeforeMethod
		public void setup()
		{
			driver =getDriver();
			login=new LoginPage(driver);
			admin =new AdminPage(driver) ;
			leave =new LeavePage(driver);
			signout=new Signout(driver);
		}
		
		@Test (dataProvider="ApplyLeave",dataProviderClass=DataGenerator.class)
		public void applyLeave(String uname , String password , By leaveType,By dateSelection,  String commentEntry){
			login.loginToApplication(uname, password);
			admin.navigateToLeavePage();
			leave.applyLeave(leaveType,dateSelection,commentEntry);
			
		
		

	
		}	
}
