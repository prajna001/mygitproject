package com.learnautomation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestcaseWithoutframework {
	
	public void test1() {
		// Open browser             
		FirefoxDriver driver=new FirefoxDriver();
		        
		// maximize browser
		driver.manage().window().maximize();
		        
		// Open URL
		driver.get("http://www.naukri.com/");
		        
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

}
