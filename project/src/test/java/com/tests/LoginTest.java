package com.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.HomePage;
import pages.LoginPage;
//import pages.Test;

public class LoginTest extends TestBase{
	@Test
	public void init() throws Exception{
 
			//driver.get("https://www.facebook.com");
			LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
			loginpage.setEmail("rajkumarsmonline@gmail.com");
			loginpage.setPassword("raj123456");
			loginpage.clickOnLoginButton();
			
			HomePage homepage = PageFactory.initElements(driver, HomePage.class);
			homepage.clickOnProfileDropdown();
			homepage.verifyLoggedInUserNameText();
			homepage.clickOnLogoutLink();	
		}

}
