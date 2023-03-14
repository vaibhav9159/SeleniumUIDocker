package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.baseTest;

public class ConfirmationPage extends baseTest{

	
	private WebDriver ldriver;
	public ConfirmationPage(WebDriver rdriver)
	{
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="#register-confirm h1")
	WebElement confimrationMessagePage;
	
	public String ConfirmationPageMessage()
	{
		waitForElement(ldriver,confimrationMessagePage);
		return confimrationMessagePage.getText();
	}
	
	
	@FindBy(css="a#flight-link")
	WebElement flightsLink;
	
	public boolean flightsLink()
	{
		waitForElement(ldriver,flightsLink);
		return flightsLink.isDisplayed();
	}
	
	public FlightDetailsPage clickOnFlightLink()
	{
		flightsLink.click();
		return new FlightDetailsPage(ldriver);
	}
}
