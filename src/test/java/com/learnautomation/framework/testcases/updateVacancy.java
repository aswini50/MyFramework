package com.learnautomation.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.framework.base.BaseClass;
import com.learnautomation.framework.helper.DataGenerator;
import com.learnautomation.framework.pages.AdminPage;
import com.learnautomation.framework.pages.EmployeePage;
import com.learnautomation.framework.pages.LoginPage;
import com.learnautomation.framework.pages.RecruitmentPage;
import com.learnautomation.framework.pages.Signout;

public class updateVacancy extends BaseClass {
	// Create Page Objects : Create an instance of Page Classes 	
	LoginPage login;
	AdminPage admin;
	RecruitmentPage recruitment;
	Signout signout;
	public WebDriver driver;
	
	// Before Test
		@BeforeMethod
		public void setup()
		{
			driver =getDriver();
			login=new LoginPage(driver);
			admin =new AdminPage(driver) ;
			recruitment = new RecruitmentPage(driver);
			signout=new Signout(driver);
		}
		
		@Test(dataProvider="UpdateVacancy",dataProviderClass=DataGenerator.class)
		public void updateVancacyCount(String uname, String password, String newVacancyCount){
			login.loginToApplication(uname, password);
			admin.navigateToRecruitmentPage();
			recruitment.navigateToVacancyTab();
			recruitment.updateVacancy(newVacancyCount);
			
			//Assertion to ensure leave was updated:
			
		}
		

}

