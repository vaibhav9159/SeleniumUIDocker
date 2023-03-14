package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseTest.baseTest;

public class ItineraryPage extends baseTest{

	private WebDriver ldriver;
	public ItineraryPage(WebDriver rdriver)
	{
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="#flight-confirmation h1 font")
	WebElement itineraryPageMessage;
	
	@FindBy(xpath="//font[contains(text(),'Flight Confirmation')]")
	WebElement confirmationId;
	
	@FindBy(css="table#confirm-table tr:last-of-type font")
	WebElement totalPrice;
	
	@FindBy(css="a#sign-on")
	WebElement signOff;
	
	public String itineraryPageMessage()
	{
		return itineraryPageMessage.getText();
	}
	
	public String confirmationId()
	{
		return confirmationId.getText();
	}
	
	public String totalPrice()
	{
		waitForElement(ldriver,totalPrice);
		return totalPrice.getText();
	}
	
	public boolean signOffButton()
	{
		signOff.isDisplayed();
		signOff.isEnabled();
		signOff.click();
		return true;
	}
	

}
