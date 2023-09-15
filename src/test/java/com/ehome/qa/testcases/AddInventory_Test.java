package com.ehome.qa.testcases;

import org.testng.annotations.*;

import com.ehome.qa.base.BaseTest;
import com.ehome.qa.util.UtilTest;
import com.ehpme.qa.pages.AddInventory_Page;
import com.ehpme.qa.pages.AllInventory_Page;
import com.ehpme.qa.pages.Home_Page;
import com.ehpme.qa.pages.Login_Page;

public class AddInventory_Test extends BaseTest {

	Login_Page loginpage;
	Home_Page homepage;
	AddInventory_Page addinventorypage;
	AllInventory_Page allinventorypage;
	static String sheetname = "Sheet1";
	
	public AddInventory_Test() throws Throwable {
		super();
	}

	@BeforeMethod
	public void setup() throws Throwable {
		initialization();
		loginpage = new Login_Page();
		homepage = new Home_Page();
		homepage = loginpage.VerifyLoginPage();
		addinventorypage = homepage.verifyHomePage();
	}
	
	@DataProvider
	public Object[][] exceldata() {
			Object[][] data = UtilTest.GetExcelTestData(sheetname);
			return data;
	}
	
	@Test(dataProvider = "exceldata")
    public void VerifyAddInventoryPageTest(String modelnumber, String itemtitle, String itemdescription, String height, String width, String breadth, String colorname, String actualprice, String qty) throws Throwable {
		allinventorypage = addinventorypage.VerifyAddInventoryPage(modelnumber, itemtitle, itemdescription, height, width, breadth, colorname, actualprice, qty);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
