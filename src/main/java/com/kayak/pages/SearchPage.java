package com.kayak.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kayak.base.TestBase;
import com.kayak.util.ReusableMethods;

public class SearchPage extends TestBase{
	
	ReusableMethods reusMeth;
	
	public SearchPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(@id,'-anywhere-search-dialog-close')]")
	WebElement closePopup;
	public void popUp()
	{
		reusMeth.waitForPageElementToVisible(closePopup);
		closePopup.click();	
	}
	@FindBy(xpath="(//div[contains(@id,'-info-leg-0-select-leg-checkbox-icon')])[1]")
	WebElement selectOption;
	public void searchList() {
		
		reusMeth.waitForPageElementToVisible(selectOption);
		selectOption.click();
		
	}
	
	@FindBy(xpath="(//div[contains(@id,'-origin-airport-display')])[1]")
	WebElement originCity;
	public String searchOriginCity() {
		
		String oCity=originCity.getText();
		return oCity;
		
		
	}
			
	@FindBy(xpath="(//div[contains(@id,'-destination-airport-display')])[1]")
	WebElement destCity;
	public String searchDestinationCity() {
		
		String dCity=originCity.getText();
		return dCity;
		
	}
	
/*
 * closepopup: (//button[contains(@id,'-x-dialog-close')])
 */
}
