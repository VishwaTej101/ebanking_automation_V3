package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

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
		
		//Once Login is done Asserting/ or verifying if we have landed on HomePAGE WITH THE TITLE
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
//			Logger.info("Login test passed");
			System.out.println("Print login passed");
		}else {
			Assert.assertTrue(false);
//			Logger.info("Login test failed");
			System.out.println("print login failed");

	
	}

}
}
