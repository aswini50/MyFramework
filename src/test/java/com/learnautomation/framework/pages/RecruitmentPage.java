package com.learnautomation.framework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RecruitmentPage {
	
	WebDriver driver ;
	public RecruitmentPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	By vacancyTab = By.id("menu_recruitment_viewJobVacancy");
	By jobTitle =By.linkText("Associate IT Manager");
	By openPositions =By.id("addJobVacancy_noOfPositions");
	By editSaveButton =By.id("btnSave");
	By backButton=By.id("btnBack");
	
	public void navigateToVacancyTab(){
		WebDriverWait explicit_wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(vacancyTab).click();
	}
	
	public void updateVacancy(String newVacancy){
		WebDriverWait explicit_wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(jobTitle).click();
		driver.findElement(editSaveButton).click();
		driver.findElement(openPositions).clear();
		driver.findElement(openPositions).sendKeys(newVacancy);
		driver.findElement(editSaveButton).click();
		//Assert.assertTrue(driver.findElement(backButton).isSelected());
		Assert.assertTrue(driver.findElement(backButton).isDisplayed());

	}
//	Clear the value and add 0
	

	

}
