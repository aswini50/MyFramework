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
	
	

	@DataProvider(name = "AddEmployee")
	public static Object[][] setEmployeeDataForApplication() 

	{
		System.out.println("LOG:INFO- Test Data is getting prepared");

		ExcelReader excel = new ExcelReader();

		int row = excel.getRowCount("Emp");

		int column = excel.getColumnCount("Emp");

		Object[][] arr = new Object[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = excel.getCellData("Emp", i, j);
			}
		}

		System.out.println("LOG:INFO: Test Data is ready");
		return arr;
	}
	@DataProvider(name = "EmployeeList")
	public static Object[][] serachtEmployeeList() 

	{
		System.out.println("LOG:INFO- Test Data is getting prepared");

		ExcelReader excel = new ExcelReader();

		int row = excel.getRowCount("EmpList");

		int column = excel.getColumnCount("EmpList");

		Object[][] arr = new Object[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = excel.getCellData("EmpList", i, j);
			}
		}

		System.out.println("LOG:INFO: Test Data is ready");
		return arr;
	}
	@DataProvider(name = "ApplyLeave")
	public static Object[][] applyLeave() 

	{
		System.out.println("LOG:INFO- Test Data is getting prepared");

		ExcelReader excel = new ExcelReader();

		int row = excel.getRowCount("ApplyLeave");

		int column = excel.getColumnCount("ApplyLeave");

		Object[][] arr = new Object[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = excel.getCellData("ApplyLeave", i, j);
			}
		}

		System.out.println("LOG:INFO: Test Data is ready");
		return arr;
	}

	@DataProvider(name = "UpdateVacancy")
	public static Object[][] updateVacancy() 

	{
		System.out.println("LOG:INFO- Test Data is getting prepared");

		ExcelReader excel = new ExcelReader();

		int row = excel.getRowCount("Vacancy");

		int column = excel.getColumnCount("Vacancy");

		Object[][] arr = new Object[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = excel.getCellData("Vacancy", i, j);
			}
		}

		System.out.println("LOG:INFO: Test Data is ready");
		return arr;
	}


}