package com.ehpme.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ehome.qa.base.BaseTest;
import com.ehome.qa.util.UtilTest;

public class AddInventory_Page extends BaseTest{

	@FindBy(xpath="//select[@id='catDD']")
	WebElement categorydrp;
	
	@FindBy(name="SubCategoryId")
	WebElement subcategorydrp;
	
	@FindBy(name="ModelNumber")
	WebElement modelnum;
	
	@FindBy(name="Title")
	WebElement itemt;
	
	@FindBy(name="ItemDescription")
	WebElement itemdesc;
	
	@FindBy(xpath="//input[@name='Height']")
	WebElement height;
	
	@FindBy(xpath="//input[@name='Width']")
	WebElement width;
	
	@FindBy(xpath="//input[@name='Breadth']")
	WebElement breadth;
	
	@FindBy(xpath="//input[@name='ColorName']")
	WebElement colorname;
	
	@FindBy(id="RecievedDate")
	WebElement recieveddate;
	
	@FindBy(xpath="//input[@name='ActualPrice']")
	WebElement actualprice;
	
	@FindBy(id="factor")
	WebElement mrpfactor;
	
	@FindBy(xpath="//input[@name='Qty']")
	WebElement qty;
	
	@FindBy(xpath="//input[@name='ProductMainImageUploaded']")
	WebElement primaryimgupload;
	
	@FindBy(name="ProductOtherImagesUploaded")
	WebElement otherimage;
	
	@FindBy(name="DocumentsUploaded")
	WebElement documentsupload;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement savebtn;
	
	public AddInventory_Page() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}
    public AllInventory_Page VerifyAddInventoryPage(String modelnumber, String itemtitle, String itemdescription, String height, String width, String breadth, String colorname, String actualprice, String qty   ) throws Throwable {
    	UtilTest.DropdownMethod(categorydrp, "Balcony");
    	UtilTest.DropdownMethod( subcategorydrp, "chairs");
    	modelnum.sendKeys(modelnumber);
    	itemt.sendKeys(itemtitle);
    	itemdesc.sendKeys(itemdescription);
    	this.height.sendKeys(height);
    	this.width.sendKeys(width);
		this.breadth.sendKeys(breadth);
		this.colorname.sendKeys(colorname);
        String date = "17-02-2023";
        recieveddate.sendKeys(date);
		this.actualprice.sendKeys(actualprice);
		this.qty.clear();
//		this.qty.toString();
		this.qty.sendKeys(qty);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", primaryimgupload);
    	UtilTest.UploadFile();
    	js.executeScript("arguments[0].click();", otherimage);
    	UtilTest.UploadFile();
    	js.executeScript("arguments[0].click();", documentsupload);
    	UtilTest.UploadFile();
    	savebtn.click();
    	return new AllInventory_Page();
    }
}
