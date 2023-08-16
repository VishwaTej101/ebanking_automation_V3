package com.inetbanking.testCases;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	

//    @BeforeClass
//    public void setupForThisTestCase() {
//        extentReportsForThisTestCase = new ExtentReports();
//
//        File file = new File(System.getProperty("user.dir") + "\\test-output\\" + this.getClass().getSimpleName() + ".html");
//        ExtentSparkReporter extentSpark = new ExtentSparkReporter(file);
//        extentReportsForThisTestCase.attachReporter(extentSpark);
//        
//        test1 = extentReportsForThisTestCase.createTest("Login Test - TC_LoginTest"); // Create the ExtentTest
//    }

	
	//Calling the Login page object class first
	@Test
	public void loginTest() {
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(banking_username);
		lp.setPassword(banking_password);
//	    ExtentReports extentReportsForThisTestCase;
	    ExtentTest test1=extentReports.createTest("Banking_Login_Page_TC");; // Add this instance variable for the ExtentTest

		
		//Once Login is done Asserting/ or verifying if we have landed on HomePAGE WITH THE TITLE
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			System.out.println("Print login passed");
			test1.log(Status.PASS, "Login test Passed");
		}else {
			Assert.assertTrue(false);
			System.out.println("print login failed");
			test1.log(Status.FAIL, "Login test failed");
		}
	}
	
//	@AfterClass
//	public void tearDownForThisTestCase() {
//	    extentReportsForThisTestCase.flush();
//	}

}
