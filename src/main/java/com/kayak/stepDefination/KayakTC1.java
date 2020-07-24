package com.kayak.stepDefination;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.kayak.base.TestBase;
import com.kayak.pages.HomePage;
import com.kayak.pages.SearchPage;
import com.kayak.util.ReusableMethods;

import TestData.ExcelData;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.kayak.ReportLogListeners.TestNGListeners.class)
public class KayakTC1 extends TestBase{
	
	public static Logger log = Logger.getLogger(KayakTC1.class.getName());
	HomePage homePage;
	SearchPage searchPage;
	String sheetName="OriginCity";
	JavascriptExecutor js;
	
	public KayakTC1() {
		super();
		
	}
	
	@BeforeMethod
	@Given("^Launch Appication chrome$")
	public void launch_Appication_firefox() throws Throwable {
	   
		ReusableMethods.launch_Browser("ch");
		log.info("Launched Browser successfully");
		homePage = new HomePage();		
		//validating kayak image
		//boolean flag = homePage.validatekayakImage();
		//Assert.assertTrue(flag);
		//log.info("Image is validating");
		
	}
	
	@Test(priority=1)
	@When("^Click on flight tab$")
	public void click_on_flight_tab() throws Exception  {
	    
		homePage.clickFlightsTab();
		log.info("Click Flight tab");
		String titleText=homePage.validateHomePageTitle();
	    log.info(titleText);
	    assertEquals(titleText, "Search hundreds of flight sites at once.");
		
	}
	
	/*@DataProvider(name="City")
	public Object[][] getOriginCity() throws Exception
	{
		Object data[][] = ExcelData.readDataFromExcelSheet("sheetName");
		return data;	
	}
	
	@Test(priority=2, dataProvider="City")
	*/
	@Test(priority=2)
	@When("^Enter OriginCity \"([^\"]*)\", DestinationCity \"([^\"]*)\"$")
	public void enter_OriginCity_DestinationCity(String originCity, String destinationCity) throws Throwable {
		
		//homePage.cancelDefaultFliOption();
		//log.info("Default flight option cancelled");
		homePage.enterOriginCity(originCity);
		log.info("Origin city is entered.");
		homePage.enterDestinationCity(destinationCity);
		log.info("Clicked on destination.");
		log.info("Destination city is entered.");
		
	}
	
	@Test(priority=3)
	@Then("^DepartureDate and ReturnDate$")
	public void departuredate_and_ReturnDate() throws Throwable {
		
		//homePage.selectFromDate();
		log.info("Clicked on From Date");
		homePage.enterFromDate();
		log.info("Selected From Date");
		homePage.enterToDate();
		log.info("Selected To Date");
		log.info("Selected Departure date and Return date");
		//js.executeScript("window.scrollBy(0,0)");
	   // log.info("Window scrolled up");
		
	}
	
	@Test(priority=4)
	@Then("^Click on Search button$")
	public void click_on_Search_button() throws Throwable {
		
		homePage.clickSearch();
		log.info("Clicked on Search button");
		log.info("All information entered successfully and navigated to search page.");
		
	}
	
	@Test(priority=5)
	@When("^Select one option from search$")
	public void select_one_option_from_search() throws Throwable {
		
		searchPage=new SearchPage();
		searchPage.popUp();
		log.info("Closed the pop up.");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		log.info("Window scrolled down");
		searchPage.searchList();
		log.info("Option is selected.");
	    js.executeScript("window.scrollBy(0,0)");
	    log.info("Window scrolled up");
		
	}
	
	@Test(priority=6)
	@Then("^Verify and Validate origin and destination cities$")
	public void verify_and_Validate_origin_and_destination_cities() throws Throwable {
		
		String homePageOriginText=homePage.homeOriginCity();
		log.info(homePageOriginText);
		String searchPageOriginText=searchPage.searchOriginCity();
		log.info(searchPageOriginText);
		assertEquals(homePageOriginText,searchPageOriginText, "Origin Cities are same");
		log.info("Origin Cities are same");
		
		String homePageDestinationText=homePage.homeDestinationCity();
		log.info(homePageDestinationText);
		String searchPageDestinationText=searchPage.searchDestinationCity();
		log.info(searchPageDestinationText);
		assertEquals(homePageDestinationText,searchPageDestinationText, "Destination Cities are same");
		log.info("Destination Cities are same");
	   
	}
			
	
	
	@AfterMethod
	@And("^Close Browser$")
	public void close_Browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReusableMethods.quit_browser();
		log.info("Quit the browser.");
	}

}
