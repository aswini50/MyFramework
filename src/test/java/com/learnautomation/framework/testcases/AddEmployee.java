package com.learnautomation.framework.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.framework.base.BaseClass;
import com.learnautomation.framework.helper.DataGenerator;
import com.learnautomation.framework.pages.AdminPage;
import com.learnautomation.framework.pages.EmployeePage;
import com.learnautomation.framework.pages.LoginPage;
import com.learnautomation.framework.pages.Signout;

public class AddEmployee extends BaseClass{
	
// Create Page Objects : Create an instance of Page Classes 
	LoginPage login ;
	AdminPage admin ;
	EmployeePage employeeAdd;
	Signout signout ;

// Before Test
	@BeforeMethod
	public void setup()
	{
		login=new LoginPage(driver);
		admin =new AdminPage(driver) ;
		employeeAdd = new EmployeePage(driver);
		signout=new Signout(driver);
	}
	

	
	@Test(dataProvider="AddEmployee",dataProviderClass=DataGenerator.class) // --> Review line with Mukesh
	public void addEmployeeAsAdmin(String uname,String pass ,String first_name,String middle_name,String last_name,String emp_ID,String photo_file,String user_name_creation,String password_creation,String status_dropdown)
	{
		
		
		login.loginToApplication(uname,pass);
		admin.navigateToEmployeePage();
		employeeAdd.addEmployee(first_name, middle_name, last_name, emp_ID, photo_file, user_name_creation, password_creation, status_dropdown);
		signout.logOut();
		
	}
	
}
