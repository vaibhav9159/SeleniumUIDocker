package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseTest.baseTest;

public class FlightDetailsPage extends baseTest{

	
	private WebDriver ldriver;
	public FlightDetailsPage(WebDriver rdriver)
	{
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="#flight-details h1")
	WebElement flightPageMessage;
	
	@FindBy(css="select#passCount")
	WebElement passengers;
	
	@FindBy(css="input#findFlights")
	WebElement continueButton;
	
	public String flightPageMessage() throws InterruptedException
	{
//		Thread.sleep(3000);
		waitForElement(ldriver,flightPageMessage);
		return flightPageMessage.getText();
	}
	
	public void passengers(String value) throws InterruptedException
	{
//		Thread.sleep(3000);
		waitForElement(ldriver,passengers);
		Select s = new Select(passengers);
		s.selectByValue(value);
	}
	
	public FlightDeparturePage continueButton()
	{
		waitForElement(ldriver,continueButton);
		continueButton.click();
		return new FlightDeparturePage(ldriver);
	}
	
	

}
