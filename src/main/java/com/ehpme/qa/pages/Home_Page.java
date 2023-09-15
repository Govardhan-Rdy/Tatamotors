package com.ehpme.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ehome.qa.base.BaseTest;


public class Home_Page extends BaseTest{

	@FindBy(xpath="//i[@class='fa fa-houzz']")
	WebElement inventory;
	
	@FindBy(xpath="//a[@href='/Inventory/InventoryDataa']")
	WebElement addinventory;
	
	public Home_Page() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}
	public AddInventory_Page verifyHomePage() throws Throwable  {
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(inventory).build().perform();
//	    inventory.click();
		addinventory.click();
		return new AddInventory_Page();

}}
