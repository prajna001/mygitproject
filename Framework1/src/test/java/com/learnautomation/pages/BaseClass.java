package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	
	
	@BeforeSuite
	public void setupSuite() {
		
		
		Reporter.log("Setting up reports and tests started",true);
		 excel=new ExcelDataProvider();
		 config=new ConfigDataProvider();
		 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM+"+Helper.getCurrentDateTime()+".html"));
		 report=new ExtentReports();
		 report.attachReporter(extent);
		 Reporter.log("Testinng can be done",true);
		 
	}
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		BrowserFactory.StartApplication(driver, browser, config.getStagingURL());
	}
	
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	//run after every testcase
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
			
		}
		report.flush();
		
	}
}
