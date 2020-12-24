package com.learnautomation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	WebDriver driver;
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	By Admin_Tab = By.xpath("//b[text()='Admin']");
	By PIM_Tab = By.id("menu_pim_viewPimModule") ;
	By EmpList_Tab = By.id("menu_pim_viewEmployeeList");
	By leaveTab=By.id("menu_leave_viewLeaveModule");
	By applyLeaveTab = By.id("menu_leave_applyLeave");

	
	public void navigateToEmployeePage(){
	//Dashboard 
	// Locator
	// Should this passed as an argument ?(Locator should be outside)
	
	// Navigation
		driver.findElement(Admin_Tab).click();
		driver.findElement(PIM_Tab).click();

	
	}
	
	public void navigateToEmployeeListPage(){
	
		
		// Navigation
			driver.findElement(Admin_Tab).click();
			driver.findElement(PIM_Tab).click();
			driver.findElement(EmpList_Tab).click();
			
		
		}
	
	public void navigateToLeavePage(){
		driver.findElement(leaveTab).click();
		driver.findElement(applyLeaveTab).click();

	}
}
