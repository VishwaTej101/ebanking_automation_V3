package com.inetbanking.utilites;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}catch(Exception e){
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	///Banking domain readConfig functions
	
	public String getBankingApplicationURL() {
		String Bankurl = prop.getProperty("bankingURL");
		return Bankurl;
	}
	
	
	public String getBanking_Username() {
		String Bankusername = prop.getProperty("bankingUserName");
		return Bankusername;
	}
	
	public String getBanking_Password() {
		String Bankpassword = prop.getProperty("bankingPassword");
		return Bankpassword;
	}
	
	//Insurance Domain readconfig functions
	
	public String getInsuranceApplicationURL() {
		String Insuranceurl = prop.getProperty("insuranceURL");
		return Insuranceurl;
	}
	public String getInsurance_Username() {
		String Insuranceusername = prop.getProperty("insurance_UserName");
		return Insuranceusername;
	}
	
	public String getInsurance_Password() {
		String Insurancepassword = prop.getProperty("insurance_Password");
		return Insurancepassword;
	}
	
	
//All browser Driver readconfig functions
	public String getFirefoxDriver() {
		String fDriver = prop.getProperty("Firefox_driver");
		return fDriver;
	}
	
	public String getChromeDriver() {
		String CDriver = prop.getProperty("Chrome_driver");
		return CDriver;
	}
}
	
//public class ReadConfig {
//
//>>>>>>> 5db78eef19641caa7aa6022a1ebba826339873a0
//}
