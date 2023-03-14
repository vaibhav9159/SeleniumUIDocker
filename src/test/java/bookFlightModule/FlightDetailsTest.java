package bookFlightModule;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import BaseTest.baseTest;
import ConfigReader.ConfigFileReader;
import DriversFactory.driversFactory;
import PageObjects.ConfirmationPage;
import PageObjects.FlightDetailsPage;
import PageObjects.RegistrationPage;
import Utils.baseUtils;

public class FlightDetailsTest extends baseTest{
	
	WebDriver driver;
	private	RegistrationPage rpage;
	baseUtils b;
	ConfirmationPage cp;
	FlightDetailsPage fp;
	
	@Test(priority=1)
//	@BeforeClass
	public void navigateToFlightDetailsPage() throws Exception
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
		log.info("thread--->" +Thread.currentThread().getId());
	}
	
	@Test(priority=2)
	public void validatePageTitle()
	{
		AssertJUnit.assertEquals(rpage.pageTitle(),"Flight Booking Form");
	}
	
	@Test(priority=3)
	public void validateFlightMessage() throws InterruptedException
	{
		AssertJUnit.assertEquals(fp.flightPageMessage(), "Flight Details Page");
		log.info("flight details page message is displayed successully");
	}
	
	@Test(priority=4)
	public void passengersCount() throws InterruptedException
	{
		fp.passengers(b.passengers());
		log.info("passengers count--->" +b.passengers());
	}
	
}
