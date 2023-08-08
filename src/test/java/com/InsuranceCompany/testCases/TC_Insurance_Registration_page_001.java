package com.InsuranceCompany.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InsuranceCompany.testObjects.Ins_Registration_Page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TC_Insurance_Registration_page_001 extends Insurance_BaseClass {
	// Calling the Login page object class first
	@Test
	public void RegPage() {
		driver.manage().window().maximize();
		Ins_Registration_Page lp = new Ins_Registration_Page(driver);

	    ExtentTest test4 = extentReports.createTest("Insurance Registration Test - TC_Insurance_Registration_page");

		lp.clickRegister();
		lp.setFirstName("Value");
		lp.setSurName("data");
		lp.setPhone("999999999");
		lp.setAddress("data");
		lp.setCity("data");
		lp.setCountry("data");
		lp.setPostCode("531117");
		
		//Here random email is generated with @test appending it 
		
		String email = randomeString() + "@test.com";
		lp.setEmail(email);
		
		lp.setPassword("password");
		lp.setConfPwd("password");
		lp.clickCreate();
		
	
		if(driver.getTitle().equals("Insurance Broker System - Register")) {
			Assert.assertTrue(true);
//			Logger.info("Login test passed");
			System.out.println("Insurance Registration login passed");
			test4.log(Status.PASS, "Login test Passed");
		}else {
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
	
	

	
}
