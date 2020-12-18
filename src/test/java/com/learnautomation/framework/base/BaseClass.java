package com.learnautomation.framework.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.learnautomation.framework.helper.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	
	public WebDriver getDriver(){
		return driver;
		
	}
	
	@BeforeClass
	public WebDriver startBrowser()
	{
		
		System.out.println("********** Starting Session **********");
		
	
		
		String browser=ConfigReader.getProperty("Browser");
		String appURL=ConfigReader.getProperty("stagingURL");
		
		System.out.println("Test is running on "+browser);
		System.out.println("URL "+appURL);
	
		if(browser.equalsIgnoreCase("Chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "");
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("********** Starting Session **********");
		
		return driver;
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("********** Closing Session **********");
		//driver.quit();
		System.out.println("********** Session Closed **********");
	}
	
}
