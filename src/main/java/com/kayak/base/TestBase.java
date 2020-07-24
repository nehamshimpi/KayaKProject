package com.kayak.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.kayak.ReportLogListeners.WebEventListener;
import com.kayak.util.ReusableMethods;

import TestData.ScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver = null ;
	public static Properties prop;
	public static ReusableMethods reuseMeth=new ReusableMethods();
	
	
	/*public TestBase() {
	
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("/Users/neha/eclipse-workspace/BDDKayakProject/src/main/java/com/kayak/config/config.properties"));
				prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	} 
	
	public static void launch_Browser() throws Exception {
		// TODO Auto-generated method stub
		String browserName=prop.getProperty("browser");

		if (browserName.startsWith("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browserName.startsWith("ff")) {
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
	}*/
	
	/*public static void quit_browser() {
		driver.quit();
	}*/
}
