package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.baseTest;

public class RegistrationPage extends baseTest{

	private WebDriver ldriver;
	public RegistrationPage(WebDriver rdriver)
	{
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="input[name='firstName']")
	private WebElement firstName;
	
	@FindBy(css="input[name='lastName']")
	private WebElement lastName;
	
	@FindBy(css="input[name='phone']")
	WebElement phone;
	
	@FindBy(css="#userName")
	WebElement email;
	
	@FindBy(css="input[name='address1']")
	WebElement address;
	
	@FindBy(css="input[name='city']")
	WebElement city;
	
	@FindBy(css="input[name='state']")
	WebElement state;
	
	@FindBy(css="input[name='state']")
	WebElement postalCode;
	
	@FindBy(css="select[name='country']")
	WebElement country;
	
	@FindBy(css="*[name='country'] option")
	List <WebElement> countriesList;
	
	@FindBy(css="#email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="input[name='confirmPassword']")
	WebElement confirmPassword;
	
	@FindBy(css="input#register-btn")
	WebElement submitButton;

	
	public void enterfirstname(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void enterlastname(String fname)
	{
		lastName.sendKeys(fname);
	}
	
	public void enterphone(String Phone)
	{
		phone.sendKeys(Phone);
	}
	
	public void enteremail(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void userName(String uname)
	{
		userName.sendKeys(uname);
	}
	
	public void password(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void confirmPassword(String ConfirmPassword)
	{
		confirmPassword.sendKeys(ConfirmPassword);
	}
	
	public ConfirmationPage submit()
	{
		waitForElement(ldriver,submitButton);
		submitButton.click();
		return new ConfirmationPage(ldriver);
	}
	
	public void selectCountry(String countryName)
	{
		country.click();
		for(WebElement e: countriesList)
		{
			if(e.getText().equalsIgnoreCase(countryName))
			{
				e.click();
			}
		}
	}
	
	public String pageTitle()
	{
		return ldriver.getTitle();
	}
	
}
