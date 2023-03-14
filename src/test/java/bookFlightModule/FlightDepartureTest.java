package bookFlightModule;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
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
import PageObjects.FlightDeparturePage;
import PageObjects.FlightDetailsPage;
import PageObjects.RegistrationPage;
import Utils.baseUtils;

public class FlightDepartureTest extends baseTest{
	
	WebDriver driver;
	private	RegistrationPage rpage;
	baseUtils b;
	ConfirmationPage cp;
	FlightDetailsPage fp;
	FlightDeparturePage fd;
	
	@Test(priority=1)
//	@BeforeClass
	public void navigateToFlightDeparturepage() throws Exception
	{
		rpage = new RegistrationPage(driversFactory.getDriver());
		b = new baseUtils();
		driver = driversFactory.getDriver();
		rpage.enterfirstname(b.firstName());
		rpage.enterlastname(b.lastName());
		rpage.enterphone(b.phone());
		rpage.enteremail(b.email());
		rpage.selectCountry(b.country());
		rpage.userName(b.userName());
		rpage.password(b.password());
		rpage.confirmPassword(b.confirmPassword());	
		cp = rpage.submit();	
		fp = cp.clickOnFlightLink();
		fp.passengers(b.passengers());
		fd = fp.continueButton();
		log.info("thread--->" +Thread.currentThread().getId());
	}
	
	@Test(priority=2)
	public void validatePageTitle()
	{
		AssertJUnit.assertEquals(rpage.pageTitle(),"Flight Booking Form");
	}
	
	@Test(priority=3)
	public void validateFlightMessage()
	{
		AssertJUnit.assertEquals(fd.flightDepartureTitle(), "Select Flight - Departure");
		AssertJUnit.assertEquals(fd.flightReturnTitle(), "Select Flight - Return");
		log.info("flight departue page is displayed, assertions successfull");
	}
	
	
}
