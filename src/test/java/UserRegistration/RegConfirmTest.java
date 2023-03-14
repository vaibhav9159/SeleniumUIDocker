package UserRegistration;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.baseTest;
import ConfigReader.ConfigFileReader;
import DriversFactory.driversFactory;
import PageObjects.ConfirmationPage;
import PageObjects.RegistrationPage;
import Utils.baseUtils;

public class RegConfirmTest extends baseTest{
	
	WebDriver driver;
	private	RegistrationPage rpage;
	baseUtils b;
	ConfirmationPage cp;
	
	@Test(priority=1)
	public void landOnRegistrationConfirmPage() throws Exception
	{
		rpage = new RegistrationPage(driversFactory.getDriver());
		cp = rpage.submit();
		log.info("thread--->" +Thread.currentThread().getId());
	}
	
	@Test(priority=2)
	public void validatePageTitle()
	{
		AssertJUnit.assertEquals(rpage.pageTitle(),"Flight Booking Form");
	}
	
	@Test(priority=3)
	public void validateConfirmationMessage()
	{
		AssertJUnit.assertEquals(cp.ConfirmationPageMessage(), "Registration Confirmation Page");
		log.info("confirmation message match success");
	}
	
	@Test(priority=4)
	public void verifyFlightLink()
	{
		AssertJUnit.assertTrue(cp.flightsLink());
	}
	
	
}
