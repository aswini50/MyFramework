package com.learnautomation.framework.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.framework.base.BaseClass;
import com.learnautomation.framework.helper.DataGenerator;
import com.learnautomation.framework.pages.LoginPage;
import com.learnautomation.framework.pages.Signout;
import com.learnautomation.framework.pages.UserPage;

public class CreateUserTest extends BaseClass{
	
	LoginPage login;
	Signout signout;
	UserPage user;
	
	@BeforeMethod
	public void setup()
	{
		login=new LoginPage(driver);
		user=new UserPage(driver);
		signout=new Signout(driver);
	}
	
	
	@Test(priority=1)
	public void loginWithAdmin()
	{
		login.loginToApplication("Admin","admin123");	
		
	}
	
	@Test(priority=2)
	public void createUser()
	{
		user.addUser();
	}
	
	@Test(priority=3)
	public void signoutApp()
	{
		signout.logOut();
	}
	
	/*@Test(dataProvider="SingleLogin",dataProviderClass=DataGenerator.class)
	public void loginWithAdmin(String uname,String pass,String prod,String quan,String description)
	{
		login.loginToApplication(uname,pass);	
		shop.addProduct(prod, quan, description);
		signout.logOut();
	}*/
	
}
