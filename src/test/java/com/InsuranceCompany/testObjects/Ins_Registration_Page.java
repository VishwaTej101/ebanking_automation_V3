package com.InsuranceCompany.testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ins_Registration_Page {

	
	WebDriver ldriver;
	//
	//
//		public LoginPage(WebDriver rdriver) {
//			ldriver = rdriver;
//			PageFactory.initElements(rdriver, this);
	//
//		}
	//	
////		Xpath of all the webElements
	//
//		@FindBy(xpath = "//input[@name='uid']")
//		WebElement txtUserName;
	//
//		@FindBy(xpath = "//input[@name='password']")
//		WebElement txtPassword;
	//
//		@FindBy(xpath = "//input[@name='btnLogin']")
//		WebElement btnLogin;
	//
		@FindBy(xpath = "//a[normalize-space()='Log out']")
		@CacheLookup
		WebElement LnkLogout;

	//	
	//Initializing all the above webelements

		public Ins_Registration_Page(WebDriver rdriver) {
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);

		}

		@FindBy(xpath = "")
		WebElement RegistrationBtn;
		
		@FindBy(xpath = "")
		WebElement txtFirstName;
		
		@FindBy(xpath = "")
		WebElement txtSurName;

		@FindBy(xpath = "")
		WebElement txtPhone;

		@FindBy(xpath = "")
		WebElement txtAddress;
		
		@FindBy(xpath = "")
		WebElement txtCity;
		
		@FindBy(xpath = "")
		WebElement txtCountry;
		
		@FindBy(xpath = "")
		WebElement txtPostCode;
		
		@FindBy(xpath = "")
		WebElement txtEmail;
		
		@FindBy(xpath = "")
		WebElement txtPassword;
		
		@FindBy(xpath = "")
		WebElement txtConfirmPassword;
		
		@FindBy(xpath = "")
		WebElement CreateBtn;

		public void clickRegister() {
			RegistrationBtn.click();
		}
		
		

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);
		}

		public void clickSubmit() {
			CreateBtn.click();
		}

		public void clickLogout() {
			LnkLogout.click();
		}

//		public void setPassword(String pwd) {
//			txtPassword.sendKeys(pwd);
//		}

//		public void clickSubmit() {
//			btnLogin.click();
//		}

}
