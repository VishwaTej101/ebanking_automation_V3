package com.inetbanking.testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.utilites.ReadConfig;

public class BaseClass {

//    protected static ExtentReports extentReports;

    ReadConfig readconfig = new ReadConfig();

    public String baseURL = "https://demo.guru99.com/v3/index.php";// readconfig.getURL();
    public String username = "mngr516186";// readconfig.getusername();
    public String password = "requduh"; // readconfig.getpassword()
    public static WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br) {

        // Set up extent report for this test class
//        extentReports = new ExtentReports();
//
//        File file = new File(System.getProperty("user.dir") + "\\test-output\\" + this.getClass().getSimpleName() + ".html");
//        ExtentSparkReporter extentSpark = new ExtentSparkReporter(file);
//        extentReports.attachReporter(extentSpark);

        // Initialize WebDriver based on browser parameter
        if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.33.0-win32\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\geckodriver-v0.33.0-win32\\geckodriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown() {
        // Flush the extent report for this test class
//        extentReports.flush();

        // Quit the WebDriver
        driver.quit();
    }
}
