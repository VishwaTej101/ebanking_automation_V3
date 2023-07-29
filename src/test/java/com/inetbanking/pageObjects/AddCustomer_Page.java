package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer_Page {

	WebDriver ldriver;

	public AddCustomer_Page(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Xpath for all the WebElements

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.XPATH, using = "//input[@value='m']")
	@CacheLookup
	WebElement rdGender;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;

//	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
//	@CacheLookup
//	WebElement txtdob;

	@FindBy(how = How.XPATH, using = "//textarea[@name='addr']")
	@CacheLookup
	WebElement txtaddress;

	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	@CacheLookup
	WebElement txtcity;

	@FindBy(how = How.XPATH, using = "//input[@name='state']")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.XPATH, using = "//input[@name='pinno']")
	@CacheLookup
	WebElement txtpinno;

	@FindBy(how = How.XPATH, using = "//input[@name='telephoneno']")
	@CacheLookup
	WebElement txttelephoneno;

	@FindBy(how = How.XPATH, using = "//input[@name='emailid']")
	@CacheLookup
	WebElement txtemailid;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(how = How.XPATH, using = "//input[@name='sub']")
	@CacheLookup
	WebElement btnSubmit;

	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
	WebElement calendar;

	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}

	public void custgender(String cgender) {
		rdGender.click();
	}

	public void calendar(String Cal) {
		Actions action = new Actions(ldriver);
		
		action.moveToElement(calendar);
		calendar.click();
	}

	
	// trouble not working for now 
	
	public void custdob(String mm, String dd, String yy) {
		txtdob.click();
		txtdob.clear();
		txtdob.sendKeys("02");
//		txtdob.sendKeys(dd);
//		txtdob.sendKeys(yy);
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtState.sendKeys(cstate);

	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void cutteephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}

}
