package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseTest.baseTest;

public class FlightDeparturePage extends baseTest{

	
	private WebDriver ldriver;
	public FlightDeparturePage(WebDriver rdriver)
	{
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="li#select-flight div#cid_37 h1:nth-of-type(1)")
	WebElement flightDepartuePageMessage;
	
	@FindBy(css="li#select-flight div#cid_37 h1:nth-of-type(2)")
	WebElement flightReturnMessage;
	
	@FindBy(css="input#reserveFlights")
	WebElement continueButton;
	
	@FindBy(css="input#buyFlights")
	WebElement continueBillingButton;
	
	public String flightDepartureTitle()
	{
		waitForElement(ldriver,flightDepartuePageMessage);
		return flightDepartuePageMessage.getText();
	}

	public String flightReturnTitle()
	{
		waitForElement(ldriver,flightReturnMessage);
		return flightReturnMessage.getText();
	}

	public ItineraryPage continueToItineraryPage()
	{
		waitForElement(ldriver,continueButton);
		continueButton.click();
		waitForElement(ldriver,continueBillingButton);
		continueBillingButton.click();
		
		return new ItineraryPage(ldriver);
	}
	

}
