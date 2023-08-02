package com.InsuranceCompany.testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ins_Registration_Page {

	
	WebDriver ldriver;
	
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

		@FindBy(xpath = "//a[@class='btn btn-default']")
		WebElement RegistrationBtn;
		
		@FindBy(xpath = "//input[@id='user_firstname']")
		WebElement txtFirstName;
		
		@FindBy(xpath = "//input[@id='user_surname']")
		WebElement txtSurName;

		@FindBy(xpath = "//input[@id='user_phone']")
		WebElement txtPhone;

		@FindBy(xpath = "//input[@id='user_address_attributes_street']")
		WebElement txtAddress;
		
		@FindBy(xpath = "//input[@id='user_address_attributes_city']")
		WebElement txtCity;
		
		@FindBy(xpath = "//input[@id='user_address_attributes_county']")
		WebElement txtCountry;
		
		@FindBy(xpath = "//input[@id='user_address_attributes_postcode']")
		WebElement txtPostCode;
		
		@FindBy(xpath = "//input[@id='user_user_detail_attributes_email']")
		WebElement txtEmail;
		
		@FindBy(xpath = "//input[@id='user_user_detail_attributes_password']")
		WebElement txtPassword;
		
		@FindBy(xpath = "//input[@id='user_user_detail_attributes_password_confirmation']")
		WebElement txtConfirmPassword;
		
		@FindBy(xpath = "//input[@name='submit']")
		WebElement CreateBtn;

		public void clickRegister() {
			RegistrationBtn.click();
		}
		
		public void setFirstName(String FirstName) {
			txtFirstName.sendKeys(FirstName);
		}
		
		public void setSurName(String SurName) {
			txtSurName.sendKeys(SurName);
		}
		
		public void setPhone(String PhNum) {
			txtPhone.sendKeys(PhNum);
		}
		
		public void setAddress(String Address) {
			txtAddress.sendKeys(Address);
		}
		
		public void setCity(String City) {
			txtCity.sendKeys(City);
		}
		
		public void setCountry(String Country) {
			txtCountry.sendKeys(Country);
		}
		
		public void setPostCode(String PCode) {
			txtPostCode.sendKeys(PCode);
		}
		
		public void setEmail(String Email) {
			txtEmail.sendKeys(Email);
		}
		

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);
		}
		
		public void setConfPwd(String CPwd) {
			txtConfirmPassword.sendKeys(CPwd);
		}

		public void clickCreate() {
			CreateBtn.click();
		}



}
