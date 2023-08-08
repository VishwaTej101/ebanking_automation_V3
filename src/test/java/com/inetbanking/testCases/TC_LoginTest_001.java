package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	
	//Calling the Login page object class first
	@Test
	public void loginTest() {
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
	    ExtentTest test1 = extentReports.createTest("Login Test - TC_LoginTest_001");
		
		//Once Login is done Asserting/ or verifying if we have landed on HomePAGE WITH THE TITLE
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
//			Logger.info("Login test passed");
			System.out.println("Print login passed");
			test1.log(Status.PASS, "Login test Passed");
		}else {
			Assert.assertTrue(false);
//			Logger.info("Login test failed");
			System.out.println("print login failed");
			test1.log(Status.FAIL, "Login test failed");

	
	}

}
}
