package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.pageObjects.AddCustomer_Page;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {
<<<<<<< HEAD
	
	ExtentReports extentReportsForThisTestCase;

    private ExtentTest test2= extentReports.createTest("Banking_Add_Customer_TC"); // Declare the extent test variable
=======

//	ExtentReports extentReportsForThisTestCase;

//    private ExtentTest test2= extentReports.createTest("Banking_Add_Customer_TC"); // Declare the extent test variable
>>>>>>> new-feature

//    @BeforeMethod
//    public void setupForThisTestCase() {
//    	
//    	 extentReportsForThisTestCase = new ExtentReports();
//
//         File file = new File(System.getProperty("user.dir") + "\\test-output\\" + this.getClass().getSimpleName() + ".html");
//         ExtentSparkReporter extentSpark = new ExtentSparkReporter(file);
//         extentReportsForThisTestCase.attachReporter(extentSpark);
//         
//        // Create extent test for this test case
//        test2 = extentReportsForThisTestCase.createTest("Add Customer test - TC_AddCustomer");
//    }

<<<<<<< HEAD
    // Calling LogIn page object class first step
    @Test
    public void addNewCustomer() throws InterruptedException {
        driver.manage().window().maximize();
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(banking_username);
        lp.setPassword(banking_password);
        lp.clickSubmit();

        // Calling and linking the Driver with AddCustomer_page object class so that we
        // can use all the webelements
        // from that class
        AddCustomer_Page addcust = new AddCustomer_Page(driver);

        addcust.clickAddNewCustomer();

        addcust.custName("Vishwa");
        addcust.custgender("male");

        // Calendar
        addcust.custdob("10", "15", "1985");

        // gave it sleep for 6 seconds total
        addcust.custaddress("INDIA");
        addcust.custcity("HYD");
        addcust.custstate("AP");
        addcust.custpinno("5000074");
        addcust.cutteephoneno("9999999999");

        // Here random email is generated with @test appending it
        String email = randomeString() + "@test.com";
        addcust.custemailid(email);
        addcust.custpassword("Zxcvbnm@123");
        addcust.custsubmit();

        // Assertion/validation once the customer has been registered properly
        boolean res = driver.getPageSource().contains("Customer Registered Successsfully!!!");

        if (res == true) {
            Assert.assertTrue(true);
            test2.log(Status.PASS, "Customer added successfully");
        } else {
            Assert.assertTrue(false);
            test2.log(Status.FAIL, "Customer is not added");
        }
    }
=======
	// Calling LogIn page object class first step
	@Test
	public void addNewCustomer() throws InterruptedException {
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(banking_username);
		lp.setPassword(banking_password);
		lp.clickSubmit();

		// Calling and linking the Driver with AddCustomer_page object class so that we
		// can use all the webelements
		// from that class
		AddCustomer_Page addcust = new AddCustomer_Page(driver);

		addcust.clickAddNewCustomer();

		addcust.custName("Vishwa");
		addcust.custgender("male");

		// Calendar
		addcust.custdob("10", "15", "1985");

		// gave it sleep for 6 seconds total
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.cutteephoneno("9999999999");

		// Here random email is generated with @test appending it
		String email = randomeString() + "@test.com";
		addcust.custemailid(email);
		addcust.custpassword("Zxcvbnm@123");
		addcust.custsubmit();

		// Assertion/validation once the customer has been registered properly
		boolean res = driver.getPageSource().contains("Customer Registered Successsfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
//            test2.log(Status.PASS, "Customer added successfully");
		} else {
			Assert.assertTrue(false);
//            test2.log(Status.FAIL, "Customer is not added");
		}
	}
>>>>>>> new-feature

//    @AfterMethod
//    public void Screenshot(ITestResult result) throws IOException {
//    	
//    	extentReportsForThisTestCase.flush();
//    	
//        if (ITestResult.FAILURE == result.getStatus()) {
//            File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(screenshotfile, new File("C:\\Users\\ASUS\\Desktop\\eclipse-workspace\\inetBanking_v1.zip_expanded\\inetBanking_v1\\Screenshots\\TC_Add_Cust_003_Fail.png"));
//        }
//    }

<<<<<<< HEAD
    // The email section cannot take the same email twice, so I have called a predefined section where the random alphabetic value
    // is called whenever the function is called
    public String randomeString() {
        String generatedstring = RandomStringUtils.randomAlphabetic(8);
        return generatedstring;
    }

    public String randomeNum() {
        String generatedstring2 = RandomStringUtils.randomNumeric(4);
        return generatedstring2;
    }
=======
	// The email section cannot take the same email twice, so I have called a
	// predefined section where the random alphabetic value
	// is called whenever the function is called
	public String randomeString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}

	public String randomeNum() {
		String generatedstring2 = RandomStringUtils.randomNumeric(4);
		return generatedstring2;
	}
>>>>>>> new-feature
}
