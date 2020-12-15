package com.learnautomation.framework.helper;

import org.testng.annotations.DataProvider;

public class DataGenerator {

	@DataProvider(name = "LoginData")
	public static Object[][] setDataForApplication() 
	{
		System.out.println("LOG:INFO- Test Data is getting prepared");

		ExcelReader excel = new ExcelReader();

		int row = excel.getRowCount("Data1");

		int column = excel.getColumnCount("Data1");

		Object[][] arr = new Object[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = excel.getCellData("Data1", i, j);
			}
		}

		System.out.println("LOG:INFO: Test Data is ready");
		return arr;
	}
	
	
	
	@DataProvider(name = "SingleLogin")
	public static Object[][] setLoginData() 
	{
		System.out.println("LOG:INFO- Test Data is getting prepared");

		ExcelReader excel = new ExcelReader();

		int row = excel.getRowCount("Login");

		int column = excel.getColumnCount("Login");

		Object[][] arr = new Object[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = excel.getCellData("Login", i, j);
			}
		}

		System.out.println("LOG:INFO: Test Data is ready");
		return arr;
	}
	
	
	@DataProvider(name = "Registration")
	public static Object[][] setRegistrationDataForApplication() 
	{
		System.out.println("LOG:INFO- Test Data is getting prepared");

		ExcelReader excel = new ExcelReader();

		int row = excel.getRowCount("Data2");

		int column = excel.getColumnCount("Data2");

		Object[][] arr = new Object[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = excel.getCellData("Data2", i, j);
			}
		}

		System.out.println("LOG:INFO: Test Data is ready");
		return arr;
	}
	
	

}
