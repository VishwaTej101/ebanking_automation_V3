package com.inetbanking.testCases;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilites.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = "https://demo.guru99.com/v3/index.php";// readconfig.getURL();
	public String username = "mngr516186";// readconfig.getusername();
	public String password = "requduh"; // readconfig.getpassword()
	public static WebDriver driver;

	// log4j code
	public static Logger Logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.33.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\geckodriver-v0.33.0-win32\\geckodriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);

		// Log4j code
//		Logger = LogManager.getLogger(BaseClass.class);
//		Logger.info("This is base class");

//		Logger = Logger.getLogger("ebanking");
//		PropertyConfigurator.configure("log4j2.properties");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}