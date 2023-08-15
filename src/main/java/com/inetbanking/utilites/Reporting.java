//package com.inetbanking.utilites;
//
//import java.text.SimpleDateFormat;
//
//import org.testng.ITestContext;
//import org.testng.TestListenerAdapter;
//
//import com.aventstack.extentreports.ExtentReports;
//
//public class Reporting extends TestListenerAdapter {
//
//	public ExtentHtmlReporter htmlReporter;
//	public ExtentReports extent;
//	public ExtentTest logger;
//	
//	public void onStart(ITestContext testContext) {
//		
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		String repName="Test-Report"+timeStamp+".html";
//		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
//		
//		extent = new ExtentReports();
//		
//		extent.attachReporter(htmlReporter);
//		extent.setSystemInfo("Host name", "localhost");
//		extent.setSystemInfo("Environment", "QA");
//		extent.setSystemInfo("user", "vishwa");
//		
//		htmlReporter.config().setDocumentTitle("InetBanking Test Project");
//		htmlReporter.config().setReportName("Functional test Report");
//		htmlReporter.config().setTestViewChartLoaction(ChartLocation.TOP);
//		
//	}
//}
