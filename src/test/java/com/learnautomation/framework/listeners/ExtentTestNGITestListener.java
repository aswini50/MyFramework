package com.learnautomation.framework.listeners;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.framework.base.BaseClass;
import com.learnautomation.framework.helper.Utility;

import net.bytebuddy.asm.Advice.Enter;

public class ExtentTestNGITestListener  implements ITestListener{
	
	

	ExtentReports extent=ExtentManager.getInstance();
	
	ExtentTest child;
	
	ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result) {
		System.out.println("********** Starting Test*********");
		ExtentTest parent=extent.createTest(result.getMethod().getMethodName());
		parentTest.set(parent);
		System.out.println("********** Test Started*********");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("********** Test Successful*********");
		parentTest.get().pass("Test Completed Successfully");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		System.out.println("********** Test Failed*********"+result.getThrowable().getMessage());
		//System.out.println("Driver Value is : " + getDriver());
		try {
		WebDriver driver = null;

		Class clazz = result.getTestClass().getRealClass();

		Field field = clazz.getDeclaredField("driver");

		driver=(WebDriver) field.get(result.getInstance());

		System.out.println("Value for driver is "+driver);

	

		
			parentTest.get().fail("Test Failed "+result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build()
					
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("********** Test Skipped*********"+result.getThrowable().getMessage());

		parentTest.get().skip("Test Skipped "+result.getThrowable().getMessage());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("********** Writing Result to report*********");
		
	}

	

}
