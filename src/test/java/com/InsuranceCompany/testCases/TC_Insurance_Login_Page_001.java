package com.InsuranceCompany.testCases;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.InsuranceCompany.testObjects.Ins_Login_page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.testCases.BaseClass;

public class TC_Insurance_Login_Page_001 extends BaseClass {

//	ExtentReports extentReportsForThisTestCase;
	
//	@BeforeClass
//	public void setupForThisTestCase() {
//		extentReportsForThisTestCase = new ExtentReports();
//
//		File file = new File(
//				System.getProperty("user.dir") + "\\test-output\\" + this.getClass().getSimpleName() + ".html");
//		ExtentSparkReporter extentSpark = new ExtentSparkReporter(file);
//		extentReportsForThisTestCase.attachReporter(extentSpark);
//
//		test3 = extentReportsForThisTestCase.createTest("Login Test - TC_LoginTest"); // Create the ExtentTest
//	}

	@Test
	public void Ins_LoginTest() {
		Ins_Login_page lp = new Ins_Login_page(driver);
		lp.setUserName("data@test.com");
		lp.setPassword("password");
		lp.clickSubmit();
		
		ExtentTest test3 = extentReports.createTest("Insurance_Login_Page_TC");; // Add this instance variable for the ExtentTest


		if (driver.getTitle().equals("Insurance Broker System")) {
			Assert.assertTrue(true);
//			Logger.info("Login test passed");
			System.out.println("Print login passed");
			test3.log(Status.PASS, "Insurance Login test Passed");
		} else {
			Assert.assertTrue(false);
//			Logger.info("Login test failed");
			System.out.println("print login failed");
			test3.log(Status.FAIL, "Insruance login test failed");
		}

	}

//	@AfterClass
//	public void tearDownForThisTestCase() {
//		extentReportsForThisTestCase.flush();
//	}

}
