package com.inetbanking.testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.utilites.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

//public class BaseClass {
//
////	protected static ExtentReports extentReports;
//
//	ReadConfig readconfig = new ReadConfig();
//
//	// Defining the base URL based on the domain
//	public String baseURL = "";
//	public static WebDriver driver;
//
//	// banking domain creds
//	public String banking_username = readconfig.getBanking_Username();
//	public String banking_password = readconfig.getBanking_Password();
//
//	// insurance domain creds
//	public String Ins_username =  readconfig.getInsurance_Username();
//	public String Ins_password = readconfig.getInsurance_Password();
//
////	@Parameters({ "browser", "domain" })
//	@BeforeClass 
//	public void setup() {
//
//		// Set up extent report for this test class
////		extentReports = new ExtentReports();
////
////		File file = new File(
////				System.getProperty("user.dir") + "\\test-output\\" + this.getClass().getSimpleName() + ".html");
////		ExtentSparkReporter extentSpark = new ExtentSparkReporter(file);
////		extentReports.attachReporter(extentSpark);
//
//		// Set base URL based on domain
////		if (domain.equalsIgnoreCase("banking")) {
////			baseURL = "https://demo.guru99.com/v3/index.php";
//////			readconfig.getBankingApplicationURL();
////		} else if (domain.equalsIgnoreCase("insurance")) {
////			baseURL = readconfig.getInsuranceApplicationURL();
////		} else {
////			throw new IllegalArgumentException("Invalid environment provided");
////		}
//		
//		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\svteja\\Downloads\\geckodriver-v0.33.0-win64(1)\\geckodriver.exe");
//
//	        // Create an instance of ChromeDriver
//	        WebDriver driver = new FirefoxDriver();
//
//	        // Open a URL in the browser
//	        driver.get("https://demo.guru99.com/v3/index.php");
//		
//        String projectPath = System.getProperty("user.dir");
//
//
//		// Initialize WebDriver based on browser parameter
////		if (br.equals("firefox")) {
////			System.setProperty("webdriver.gecko.driver", projectPath +"/inetBanking_v1/Drivers/geckodriver.exe");
////			driver = new FirefoxDriver();
////		} else if (br.equals("chrome")) {
////			System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriver());
////			driver = new ChromeDriver();
////		}
//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get(baseURL);
//	}
//
//	@AfterClass
//	public void tearDown() {
//		// Flush the extent report for this test class
////		extentReports.flush();
//
//		// Quit the WebDriver
//		driver.quit();
//	}
//}

public class BaseClass {

	public String baseURL = "https://demo.guru99.com/v3/index.php";
	public String banking_username = "mngr515722";
	public String banking_password = "gunYvAt";
	public static WebDriver driver;

	@BeforeClass
	public void setup() {
//		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\svteja\\Downloads\\geckodriver-v0.33.0-win64(1)\\geckodriver.exe");
//		driver=new FirefoxDriver();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(baseURL);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
