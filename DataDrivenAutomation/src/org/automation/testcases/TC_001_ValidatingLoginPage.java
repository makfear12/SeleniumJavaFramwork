package org.automation.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.base.DriverInstance;
import org.automation.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001_ValidatingLoginPage extends DriverInstance {

	@Test(dataProvider="Excel")
	public void tc_001_login_functionality(String uname,String pass) throws Exception
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername(uname);
		login.enterPassword(pass);
		login.ClickSignIn();
		
	}
	 
	@DataProvider(name="Excel")
	public Object TestdataGenerator() throws Exception
	{
		//Object [][] data ={{"Uname1","Pass1"},{"Uname2","Pass2"},{"Uname3","Pass3"}};
		// return data;
		FileInputStream file = new FileInputStream("C:\\Users\\Mayank\\workspace\\maven\\DataDrivenAutomation\\TestData\\TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet loginSheet = workbook.getSheet("Login"); 
		int  numberofData = loginSheet.getPhysicalNumberOfRows();
		Object [][] testdata=new Object[numberofData][2];
		for (int i=0;i<numberofData;i++)
		{
				XSSFRow row = loginSheet.getRow(i);
				XSSFCell username = row.getCell(0);
				XSSFCell password=row.getCell(1);
				testdata[i][0]= username.getStringCellValue();
				testdata[i][1]= username.getStringCellValue();
		}
	return testdata;
	}
}
