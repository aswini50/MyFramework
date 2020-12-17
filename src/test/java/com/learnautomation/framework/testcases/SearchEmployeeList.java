package com.learnautomation.framework.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.framework.base.BaseClass;
import com.learnautomation.framework.helper.DataGenerator;
import com.learnautomation.framework.pages.AdminPage;
import com.learnautomation.framework.pages.EmployeeList;
import com.learnautomation.framework.pages.LoginPage;
import com.learnautomation.framework.pages.Signout;

public class SearchEmployeeList extends BaseClass {

	//Create Page Objects 
	LoginPage login;
	AdminPage admin;
	EmployeeList empList;
	Signout signout;
	
	// Before Test
		@BeforeMethod
		public void setup()
		{
			login=new LoginPage(driver);
			admin =new AdminPage(driver) ;
			empList = new EmployeeList(driver);
			signout=new Signout(driver);
		}
	
	// Test Method
		
		@Test(dataProvider="EmployeeList",dataProviderClass=DataGenerator.class) 
		
		public void searchEmpList(String uname,String pass ,String name){
			
			login.loginToApplication(uname,pass);
			admin.navigateToEmployeeListPage();;
			empList.searchForEmp(name);
			signout.logOut();
			
		}
}
