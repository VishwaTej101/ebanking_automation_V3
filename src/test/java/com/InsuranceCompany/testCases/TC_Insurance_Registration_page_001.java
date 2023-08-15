package com.InsuranceCompany.testCases;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.InsuranceCompany.testObjects.Ins_Registration_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.testCases.BaseClass;

public class TC_Insurance_Registration_page_001 extends BaseClass {

//	ExtentReports extentReportsForThisTestCase;
	// Calling the Login page object class first

//	@BeforeClass
//	public void setupForThisTestCase() {
//		extentReportsForThisTestCase = new ExtentReports();
//
//		File file = new File(
//				System.getProperty("user.dir") + "\\test-output\\" + this.getClass().getSimpleName() + ".html");
//		ExtentSparkReporter extentSpark = new ExtentSparkReporter(file);
//		extentReportsForThisTestCase.attachReporter(extentSpark);
//
//		test4 = extentReportsForThisTestCase.createTest("Login Test - TC_LoginTest"); // Create the ExtentTest
//	}

	@Test
	public void RegPage() {
		driver.manage().window().maximize();
		Ins_Registration_Page lp = new Ins_Registration_Page(driver);

		lp.clickRegister();
		lp.setFirstName("Value");
		lp.setSurName("data");
		lp.setPhone("999999999");
		lp.setAddress("data");
		lp.setCity("data");
		lp.setCountry("data");
		lp.setPostCode("531117");

		// Here random email is generated with @test appending it

		String email = randomeString() + "@test.com";
		lp.setEmail(email);

		lp.setPassword("password");
		lp.setConfPwd("password");
		lp.clickCreate();
		
		//Instance variable for the ExtentTest
		ExtentTest test4 = extentReports.createTest("Insurance_Registration_Page_TC"); 

		if (driver.getTitle().equals("Insurance Broker System - Register")) {
			Assert.assertTrue(true);
//			Logger.info("Login test passed");
			System.out.println("Insurance Registration login passed");
			test4.log(Status.PASS, "Login test Passed");
		} else {
			Assert.assertTrue(false);
//			Logger.info("Login test failed");
			System.out.println("Insurnace registration failed");
			test4.log(Status.FAIL, "Login test failed");

		}

	}

	private String randomeString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

//	@AfterClass
//	public void tearDownForThisTestCase() {
//		extentReportsForThisTestCase.flush();
//	}

}
