package com.learnautomation.framework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage {

WebDriver driver ;

public EmployeePage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver,this);
}

//Locators of Web Elements used in Employee Page
By  addEmployee = By.xpath("//input[@value='Add']");
By  firstName =  By.xpath("//*[text()='Full Name']//following::input[1]");
By middleName = By.xpath("//*[text()='Full Name']//following::input[2]");
By lastName = By.xpath("//*[text()='Full Name']//following::input[3]");
By empID = By.xpath("//*[text()='Employee Id']//following::input[1]");
//addEmployee.click();
By photo = By.id("photofile");
By checkbox = By.cssSelector("input[type='checkbox']") ;
By userNameCreation = By.xpath("//*[text()='User Name']//following::input[1]");
By passwordCreation = By.xpath("//*[text()='Password']//following::input[1]");
By passwordConfirmation = By.xpath("//*[text()='Confirm Password']//following::input[1]");
By status = By.id("status");
//String status_in_dropdown ="enabled" ;
By options = By.tagName("option");
By saveButton = By.id("btnSave");
By PIM_Tab = By.id("menu_pim_viewPimModule") ;//Move into method

public void navigate_to_EmployeePage(){
driver.findElement(PIM_Tab).click();
} // This should be in admin page

public void selectDropdown(String status_to_pass){


for(WebElement ele:driver.findElements(options))
{
if(ele.getText().equals(status_to_pass))
{
ele.click();
break;
}
}

}

public void addEmployee(String first_name, String middle_name,String last_name,String emp_ID,String photo_file,String user_name_creation,String password_creation, String status_dropdown){

WebDriverWait explicit_wait = new WebDriverWait(driver,Duration.ofSeconds(10));
explicit_wait.until(ExpectedConditions.elementToBeClickable(addEmployee)).click();
//driver.findElement(addEmployee).click();;
driver.findElement(firstName).sendKeys(first_name);
driver.findElement(middleName).sendKeys(middle_name);
driver.findElement(lastName).sendKeys(last_name);
WebElement emp_ID_Click= driver.findElement(empID);
emp_ID_Click.clear();
emp_ID_Click.sendKeys(emp_ID);
driver.findElement(photo).sendKeys(System.getProperty("user.dir")+ "\\TestData\\" + photo_file);
//photo.sendKeys(System.getProperty("user.dir")+"/Capture.png");
driver.findElement(checkbox).click();
driver.findElement(userNameCreation).sendKeys(user_name_creation);
driver.findElement(passwordCreation).sendKeys(password_creation);
driver.findElement(passwordConfirmation).sendKeys(password_creation);
selectDropdown(status_dropdown);
driver.findElement(saveButton).submit();

}
}

