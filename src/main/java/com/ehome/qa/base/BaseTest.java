package com.ehome.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ehome.qa.util.WebEventListener;
public class BaseTest {

	public static Properties prop;
	public static WebDriver driver;
	
	public static EventFiringWebDriver e_driver; 
	public static WebEventListener eventlistener;

	public BaseTest() throws Throwable {

		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("D:\\KCSM14\\Tatamotors\\src\\main\\java\\com\\ehome\\qa\\config\\config.properties");
			prop.load(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

public static  void initialization() throws Throwable {
	String BrowserName = prop.getProperty("browser");
	if(BrowserName.equals("chrome")) {
		driver = new ChromeDriver();
	}
	else if(BrowserName.equals("firefox")) {
		driver = new FirefoxDriver();
	}
	e_driver = new EventFiringWebDriver(driver);
	eventlistener = new WebEventListener();
	e_driver.register(eventlistener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get(prop.getProperty("url"));
}
}
