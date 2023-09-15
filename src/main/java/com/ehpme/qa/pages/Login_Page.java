package com.ehpme.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ehome.qa.base.BaseTest;

public class Login_Page extends BaseTest {
 @FindBy(name="emailid")
 WebElement username;
 
 @FindBy(id="pword")
 WebElement password;
 
 @FindBy(xpath = "//button[text()='Login']")
 WebElement loginbtn;
 
 @FindBy(xpath = "//img[@src='/WebApp/assets/dist/img/logo.pngg']")
 WebElement ehomeimage;
 
	
public Login_Page() throws Throwable {
	super();
	PageFactory.initElements(driver, this);
}
public String VerifyLoginPageTitle() {
	return driver.getTitle();
}
public boolean VerifyeHomeImage() {
	return ehomeimage.isDisplayed();
}
public Home_Page VerifyLoginPage() throws Throwable {
	username.sendKeys(prop.getProperty("username"));
	password.sendKeys(prop.getProperty("password"));
	loginbtn.click();
	return new Home_Page();
}
	
}
