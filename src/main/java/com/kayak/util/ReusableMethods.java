package com.kayak.util;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kayak.ReportLogListeners.WebEventListener;
import com.kayak.base.TestBase;
import com.kayak.util.ReusableMethods;

import TestData.ScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods extends TestBase{
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	/*static void launch_Browser(String str) throws Exception {
		// TODO Auto-generated method stub

		if (str.startsWith("ch")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (str.startsWith("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			System.out.println("You have not given correct type of browser. ");
		
		}	
	}*/
	
	public static void launch_Browser(String str) throws Exception {
		// TODO Auto-generated method stub

		if (str.startsWith("ch")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (str.startsWith("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			System.out.println("You have not given correct type of browser. ");
		
		}	
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(ScreenShot.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ScreenShot.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("https://www.kayak.com/");
	}
	/*public static void Launch(String url) {
		//"https://login.salesforce.com
		driver.get(url);
		driver.manage().window().maximize();
		
		
	}*/

	public static void quit_browser() {
		driver.quit();
	}

	public void waitForPageElementToVisible(WebElement eleToWait) 
    {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(eleToWait));	
	}
	
	

}
