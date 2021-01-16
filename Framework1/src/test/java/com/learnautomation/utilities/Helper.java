package com.learnautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//custom library like screenshots,alerts,frames,multiple windoews,sync issues,javasceept executer
	
	
	public static String captureScreenShots(WebDriver driver) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/screenshots/freeCRM"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File (screenshotPath));
			System.out.println("Screenshot captured");
		} catch (Exception e) {
			System.out.println("Unable to capture screenshot "+e.getMessage());
			
		}
		return screenshotPath;
		
	}
	public static String getCurrentDateTime() {
		DateFormat format=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date=new Date();
		return format.format(date);
		
	}
	public void handleAlerts() {
		
	}

}
