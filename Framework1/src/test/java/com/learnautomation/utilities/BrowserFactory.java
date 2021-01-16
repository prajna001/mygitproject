package com.learnautomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public static WebDriver StartApplication(WebDriver driver,String browserName,String appUrl) {
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
		//	System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			driver=new FirefoxDriver();
	}
		else if(browserName.equals("IE")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
				//driver=new InternetExporerDriver();
		}
		else {
			System.out.println("We do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
