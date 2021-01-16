package com.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	
public static WebDriver driver = null;
	
	@BeforeSuite
	public void initialize() throws IOException{
			
		System.setProperty("webdriver.gecko.driver","C:\\Browserdriver\\geckodriver.exe");
		driver = new FirefoxDriver();		
		//To maximize browser
                driver.manage().window().maximize();
	        //Implicit wait
        	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//To open facebook
                driver.get("https://www.facebook.com");
		
	}
	
	@AfterSuite
	//Test cleanup
	public void TeardownTest()
    {
        TestBase.driver.quit();
    }
 

}
