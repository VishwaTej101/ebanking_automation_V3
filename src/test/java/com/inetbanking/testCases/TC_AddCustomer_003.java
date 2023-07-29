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
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomer_Page;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {

	// Calling LogIn page object class first step

	@Test
	public void addNewCustomer() throws InterruptedException {
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();

		

		// Calling and linking the Driver with AddCustomer_page object class so that we
		// can use all the webelements
		// from that class

		AddCustomer_Page addcust = new AddCustomer_Page(driver);

		addcust.clickAddNewCustomer();

		addcust.custName("Vishwa");
		addcust.custgender("male");

		// Calendar
		Thread.sleep(3000);
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		// gave it sleep for 6 seconds total

		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.cutteephoneno("9999999999");

		
		//Here random email is generated with @test appending it 
		
		String email = randomeString() + "@test.com";
		addcust.custemailid(email);
		addcust.custpassword("Zxcvbnm@123");
		addcust.custsubmit();

		Thread.sleep(4000);
//Assertion/validation once the customer has been registered properly

		boolean res = driver.getPageSource().contains("Customer Registered Successsfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@AfterMethod
	public void Screenshot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotfile, new File("C:\\Users\\ASUS\\Desktop\\eclipse-workspace\\inetBanking_v1.zip_expanded\\inetBanking_v1\\Screenshots\\TC_Add_Cust_003_Fail.png"));
		}
	}
	
//The email section cannot take same email twic so i have called a predefined section where the random alphabetic value
	// is called whenever the function is called

	public String randomeString() {

		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	public String randomeNum() {

		String generatedstring2 = RandomStringUtils.randomNumeric(4);
		return (generatedstring2);
	}

}
