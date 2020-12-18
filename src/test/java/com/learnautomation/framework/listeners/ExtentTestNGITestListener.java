package com.learnautomation.framework.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.framework.base.BaseClass;
import com.learnautomation.framework.helper.Utility;

public class ExtentTestNGITestListener  extends BaseClass implements ITestListener{

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
		System.out.println("Driver Value is : " + getDriver());
		try {
			parentTest.get().fail("Test Failed "+result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(getDriver())).build()
					
					);
		} catch (IOException e) {
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
