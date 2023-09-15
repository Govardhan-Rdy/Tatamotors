package com.ehome.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ehome.qa.base.BaseTest;


public class UtilTest extends BaseTest {

	public UtilTest() throws Throwable {
		super();
	}
    public static String ExcelData = "D:\\KCSM14\\Tatamotors\\src\\main\\java\\com\\ehome\\qa\\testdata\\EHome.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static String primaryimage = "D:\\EHOME IMAGES 2\\Bb";  
	public static String otherimage = "D:\\EHOME IMAGES 2\\cooldrinks";
	public static String documentupload = "D:\\EHOME IMAGES 2\\red";
	
	public static void DropdownMethod(WebElement ele, String value) {
		Select select = new Select(ele);
		select. selectByVisibleText(value);
	}
	
	public static Object[][] GetExcelTestData(String sheetname) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(ExcelData);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} 
		catch (IOException e) {
			e.printStackTrace();

		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int r = 0; r<sheet.getLastRowNum(); r++) {
		   for(int k = 0; k<sheet.getRow(0).getLastCellNum(); k++) {
			DataFormatter df = new DataFormatter();
			data[r][k] = df.formatCellValue(sheet.getRow(r + 1).getCell(k));
		}
		}
		return data;
	}
	
	public static void UploadFile() throws Throwable {
		Robot robot = new Robot();
		robot.delay(2000);
		StringSelection ss = new StringSelection(primaryimage);
		StringSelection ss1 = new StringSelection(otherimage);
		StringSelection ss2 = new StringSelection(documentupload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/EmpireScreenshots/" + System.currentTimeMillis() + ".png"));

//	public static void takeScreenshotAtEndOfTest(WebDriver driver, String tname) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File(System.getProperty("user.dir")+ "/Screenshot/"+ tname + ".png" );
//		FileUtils.copyFile(src, dest);
//		System.out.println("ScreenShot Taken");
//		
//	
		}
	
	
	
}
