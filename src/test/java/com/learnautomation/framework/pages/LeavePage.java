package com.learnautomation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LeavePage {
WebDriver driver ;
	
	public LeavePage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	// Navigate to LeavePage from Admin Page
	
	// Locators on LeavePage
		
	//By applyTab = By.id("menu_leave_applyLeave");
	//By personalLeaveType = By.xpath("//*[text()='Leave Type ']//following::select[1]");
	By fromDate =By.xpath("//*[text()='From Date ']//following::input[1]");
	By toDate = By.xpath("//*[text()='To Date ']//following::input[1]");
	By comment=By.xpath("//*[text()='Comment']//following::textarea");
	By submitBtn =By.xpath("//input[@value='Apply']");
	By dateSelection=By.xpath("//table[contains(@class,'calendar')]//a[text()=25]");
	By leaveType = By.xpath("//*[text()='Leave Type ']//following::select[1]");
	//By dateSelection = By.xpath("//table[contains(@class,'calendar')]//a[text()=25]");


	
	// Methods for actions
	
	public void applyLeave(String leaveCategory, String commentEntry ){
		
		Select leave =new Select(driver.findElement(leaveType));
		leave.selectByVisibleText(leaveCategory);
		driver.findElement(fromDate).click();//sendkeys will take String
		driver.findElement(dateSelection).click();
		driver.findElement(toDate).click();
		driver.findElement(dateSelection).click();
		driver.findElement(comment).sendKeys(commentEntry);
		driver.findElement(submitBtn).click();
		
		
		//*[text()='Leave Type ']//following::select[1]
		//*[text()='From Date ']//following::input[1]
		//*[text()='To Date ']//following::input[1]
		//*[text()='Comment']//following::textarea
		//*[text()='Apply ']//following::input[@value='Apply']
		
		
			
		
	}
	
 	
	
	
}


