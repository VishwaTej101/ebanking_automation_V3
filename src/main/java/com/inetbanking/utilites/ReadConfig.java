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
	
	public String getBankingApplicationURL() {
		String url = prop.getProperty("bankingURL");
		return url;
	}
	
	public String getInsuranceApplicationURL() {
		String url = prop.getProperty("insuranceURL");
		return url;
	}
	public String getBanking_Username() {
		String username = prop.getProperty("bankingUserName");
		return username;
	}
	
	public String getBanking_Password() {
		String password = prop.getProperty("bankingPassword");
		return password;
	}
	
	public String getInsurance_Username() {
		String username = prop.getProperty("insurance_UserName");
		return username;
	}
	
	public String getInsurance_Password() {
		String password = prop.getProperty("insurance_Password");
		return password;
	}
	
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
