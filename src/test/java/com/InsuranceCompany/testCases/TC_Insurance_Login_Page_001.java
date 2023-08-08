package com.InsuranceCompany.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InsuranceCompany.testObjects.Ins_Login_page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TC_Insurance_Login_Page_001 extends Insurance_BaseClass {

	@Test
	public void Ins_LoginTest() {
		Ins_Login_page lp = new Ins_Login_page(driver);
		lp.setUserName("data@test.com");
		lp.setPassword("password");
		lp.clickSubmit();
		
	    ExtentTest test3 = extentReports.createTest("Insurance Login Test - TC_Insurance_Login_Page_001");

		
		
		if(driver.getTitle().equals("Insurance Broker System")) {
			Assert.assertTrue(true);
//			Logger.info("Login test passed");
			System.out.println("Print login passed");
			test3.log(Status.PASS, "Insurance Login test Passed");
		}else {
			Assert.assertTrue(false);
//			Logger.info("Login test failed");
			System.out.println("print login failed");
			test3.log(Status.FAIL, "Insruance login test failed");
	}
	
	


}
	
	
	
	
	
}
