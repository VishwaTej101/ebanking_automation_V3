package com.inetbanking.testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilites.DataUtil;
import com.inetbanking.utilites.MyXLSReader;
import com.inetbanking.utilites.XLUtiles;

public class TC_LoginDDT_002 extends BaseClass {

	MyXLSReader excelReader;

	@Test(dataProvider = "dataSupplier")
	public void loginDDT(HashMap<String,String>hMap) {
		
		if(!DataUtil.isRunnable(excelReader,"LoginTest","TestCases")||hMap.get("Runmode").equals("N")) {
			
			throw new SkipException("Run mode is set to N, hence not executed");
		}
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		String expectedResult = hMap.get("ExpectedResult");
		
		boolean expectedConvertedResult = false;
		
		if(expectedResult.equalsIgnoreCase("Success")) {
		
			expectedConvertedResult = true;
		}else if(expectedResult.equalsIgnoreCase("Failure")) {
			expectedConvertedResult = false;
		}
		boolean actualResult = false;
		try {
			 actualResult = driver.findElement(By.linkText("Edit")).isDisplayed();
		}catch(Throwable e) {
			actualResult = false;
		}
		
		Assert.assertEquals(actualResult, expectedConvertedResult);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider
	public Object[][] dataSupplier() {
		Object[][] data = null;
		try {
			excelReader = new MyXLSReader("src\\test\\resources\\All_TestData.xlsx");
			data = DataUtil.getTestData(excelReader, "LoginTest", "Data");

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return data;
	}

//	@DataProvider(name = "LoginData")
//	String[][] getData() throws IOException {
//		String path = "C:\\Users\\ASUS\\Desktop\\eclipse-workspace\\inetBanking_v1.zip_expanded\\inetBanking_v1\\src\\test\\java\\com\\inetbanking\\testData\\LoginPage_inetBanking.xlsx";
//
//		int rownum = XLUtiles.getRowCount(path, "Sheet1");
//		int colcount = XLUtiles.getCellCount(path, "Sheet1", 1);
//
//		String logindata[][] = new String[rownum][colcount];
//
//		for (int i = 1; i <= rownum; i++) {
//
//			for (int j = 0; j < colcount; j++) {
//
//				logindata[i - 1][j] = XLUtiles.getCellData(path, "Sheet1", i, j);
//			}
//		}
//		return logindata;
//	}

//	@Test
//	public void addNewCustomer() throws InterruptedException {
//
//	}
}
