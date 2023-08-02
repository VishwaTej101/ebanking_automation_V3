package com.inetbanking.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilites.XLUtiles;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "dataSupplier")
	public void loginDDT() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);

		lp.clickSubmit();

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
	public void dataSupplier() {

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
