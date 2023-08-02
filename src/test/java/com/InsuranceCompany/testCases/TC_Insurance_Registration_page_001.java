package com.InsuranceCompany.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InsuranceCompany.testObjects.Ins_Registration_Page;

public class TC_Insurance_Registration_page_001 extends Insurance_BaseClass {
	// Calling the Login page object class first
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
		
		//Here random email is generated with @test appending it 
		
		String email = randomeString() + "@test.com";
		lp.setEmail(email);
		
		lp.setPassword("password");
		lp.setConfPwd("password");
		lp.clickCreate();
		
	
				

	}

	private String randomeString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	
}
