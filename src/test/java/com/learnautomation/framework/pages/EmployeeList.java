package com.learnautomation.framework.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmployeeList {

	WebDriver driver ;
	
	public EmployeeList(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	//Locators in this page 
	By EmpName =By.id("empsearch_employee_name_empName"); 
	By SearchButton = By.id("searchBtn");
	By Name_in_Link= By.linkText("Lisa");
	//By Name_in_Link= By.linkText("/index.php/pim/viewEmployee/empNumber/28");
	

	//Method : Search for an Employee
	
	public void searchForEmp(String name){
		driver.findElement(EmpName).sendKeys(name);
		driver.findElement(SearchButton).click();
		Assert.assertEquals(driver.findElement(Name_in_Link).getText(),name);
		

		//Assert.assertEquals(driver.findElement(Name_in_Link).getText(),equals(name));
		
	}


	
	
}
