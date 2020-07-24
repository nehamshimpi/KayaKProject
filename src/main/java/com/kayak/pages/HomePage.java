package com.kayak.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kayak.base.TestBase;
import com.kayak.util.ReusableMethods;

import TestData.ExcelData;

public class HomePage extends TestBase{
	
		// PAGE FACTORY
	
		ReusableMethods reusMeth;
		
		//Initializing the Page Objects:
		public HomePage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		@FindBy(xpath="//*[contains(@class,'title dark')]")
		WebElement validateHomePageTitle;
		public String validateHomePageTitle()
		{
			reuseMeth.waitForPageElementToVisible(validateHomePageTitle);
			String homePageTitle=validateHomePageTitle.getText();
			return homePageTitle;
		}
	
		//cancel default origin
		@FindBy(xpath="")
		WebElement cancelDefaultflight;
		public void cancelDefaultFliOption()
		{
			reuseMeth.waitForPageElementToVisible(cancelDefaultflight);
			cancelDefaultflight.click();
		}
		
		@FindBy(xpath="//*[name()='path' and contains(@fill,'#FFFFFF')]")
		WebElement kayakLogo;
		public boolean validatekayakImage()
		{
			return kayakLogo.isDisplayed();
		}
		
		@FindBy(xpath="(//a[contains(text(),'Flights')])[1]")
		WebElement flights;
		public void clickFlightsTab() throws Exception 
		{
			
			reuseMeth.waitForPageElementToVisible(flights);
			Thread.sleep(2000);
			flights.click();
		}
		
		
		
		@FindBy(xpath="(//div[contains(@id,'-origin-airport-display')])[1]")
		WebElement originCity;
		
		@FindBy(xpath="(//input[contains(@id,'-origin-airport')])[1]")
		WebElement enterOriginCity;
		
		@FindBy(xpath="(//input[contains(@id,'-destination-airport')])[1]")
		WebElement destinationCity;
		
		@FindBy(xpath="(//div[contains(@id,'-destination-airport-display')])[1]")
		WebElement enterDestinationCity;
		
		@FindBy(xpath="(//div[contains(@id,'-originDepartureSwitch')])[1]")
		WebElement arrowRevTabButton;
		
		public void enterOriginCity(String oCity)
		{
			reuseMeth.waitForPageElementToVisible(originCity);
			originCity.click();
			reuseMeth.waitForPageElementToVisible(enterOriginCity);
			enterOriginCity.sendKeys(oCity);
			enterOriginCity.sendKeys(Keys.TAB);
			reuseMeth.waitForPageElementToVisible(arrowRevTabButton);
			arrowRevTabButton.sendKeys(Keys.TAB);
			
		}
		
		public void enterDestinationCity(String dCity) 
		{
			reuseMeth.waitForPageElementToVisible(destinationCity);
			destinationCity.click();	
			reuseMeth.waitForPageElementToVisible(enterDestinationCity);
			enterDestinationCity.sendKeys(dCity);
			destinationCity.sendKeys(Keys.TAB);
		}
		
		@FindBy(xpath="(//div[@class='_iaf _iEU _iam _iai']//parent::div[contains(@id,'-dateRangeInput-display-start')])[1]")
		WebElement selectFromDate;
		public void selectFromDate()
		{
			//reuseMeth.waitForPageElementToVisible(selectFromDate);
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			wait2.until(ExpectedConditions.elementToBeClickable(selectFromDate));
			selectFromDate.click();
			
		}
		
		@FindBy(xpath="(//div[@class='_j2U _icW _icg _iq6 _ix7 _iaB _jyS _iXu _j16 _jPW _j19' and contains(text(),'31')])[1]")
		WebElement enterFromDate ;
		public void enterFromDate()
		{
			reuseMeth.waitForPageElementToVisible(enterFromDate);
			enterFromDate.click();
		}
		
		@FindBy(xpath="(//div[@class='_j2U _icW _icg _iq6 _ix7 _iaB _jyS _iXu _j16 _jPW _j19' and contains(text(),'15')])[3]")
		WebElement enterToDate;
		public void enterToDate()
		{
			reuseMeth.waitForPageElementToVisible(enterToDate);
			enterToDate.click();
			//enterToDate.sendKeys(Keys.ENTER);
			//enterToDate.sendKeys(Keys.TAB);
		}
		
		@FindBy(xpath="//span[contains(@class,'v-c-p centre')]//span[contains(@class,'icon')]//*[local-name()='svg']")
		WebElement searchButton;
		public void clickSearch()
		{
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			wait2.until(ExpectedConditions.elementToBeClickable(searchButton));
			//reuseMeth.waitForPageElementToVisible(searchButton);
			searchButton.click();
		}
		
		@FindBy(xpath="(//div[@class='js-selection-text-container _iac _iad _ia1 _iaa _iab _iaB _h-8 _ii0 _kaN'])[1]")
		WebElement fOrigin;
		public String homeOriginCity()
		{
			String foriginText=fOrigin.getText();
			return foriginText;
		}
		
		@FindBy(xpath="(//div[@class='js-selection-text-container _iac _iad _ia1 _iaa _iab _iaB _h-8 _ii0 _kaN'])[2]")
		WebElement fDestination;
		public String homeDestinationCity()
		{
			String fDestinationText=fDestination.getText();
			return fDestinationText;
		}
		

}
