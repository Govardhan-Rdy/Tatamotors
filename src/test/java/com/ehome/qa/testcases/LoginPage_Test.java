package com.ehome.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;


import com.ehome.qa.base.BaseTest;
import com.ehpme.qa.pages.Home_Page;
import com.ehpme.qa.pages.Login_Page;

public class LoginPage_Test extends BaseTest {
	
    Login_Page loginpage;
	Home_Page homepage;
	
	public LoginPage_Test() throws Throwable {
		super();
	}

	@BeforeMethod
	public void setup() throws Throwable {
		initialization();
		loginpage = new Login_Page();
		
	}
	
	@Test
	public void VerifyLoginPageTitleTest() {
		String title = loginpage.VerifyLoginPageTitle();
		Assert.assertEquals(title, "Empire Home Admin Panel");
	}
	
	@Test
	public void VerifyeHomeImageTest() {
	   boolean image = loginpage.VerifyeHomeImage();
		Assert.assertTrue(image);
	}
	
	@Test
	public void VerifyLoginPageTest() throws Throwable {
		homepage = loginpage.VerifyLoginPage();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
