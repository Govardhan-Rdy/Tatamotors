package com.ehome.qa.testcases;

import org.testng.annotations.*;

import com.ehome.qa.base.BaseTest;
import com.ehpme.qa.pages.AddInventory_Page;
import com.ehpme.qa.pages.Home_Page;
import com.ehpme.qa.pages.Login_Page;

public class HomePage_Test extends BaseTest {
    Login_Page loginpage;
    Home_Page homepage;
    AddInventory_Page addinventorypage;
	
	public HomePage_Test() throws Throwable {
		super();
		
	}
	@BeforeMethod
	public void setup() throws Throwable {
		initialization();
		loginpage = new Login_Page();
		homepage = new Home_Page();
		addinventorypage = new AddInventory_Page();
		homepage = loginpage.VerifyLoginPage();
	}
	
	@Test
	public void VerifyHomePageTest() throws Throwable {
		addinventorypage = homepage.verifyHomePage();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
