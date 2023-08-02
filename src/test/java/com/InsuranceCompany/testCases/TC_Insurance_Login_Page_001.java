package com.InsuranceCompany.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InsuranceCompany.testObjects.Ins_Login_page;

public class TC_Insurance_Login_Page_001 extends Insurance_BaseClass {

	@Test
	public void Ins_LoginTest() {
		Ins_Login_page lp = new Ins_Login_page(driver);
		lp.setUserName("data@test.com");
		lp.setPassword("password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Insurance Broker System")) {
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
