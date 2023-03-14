package bookFlightModule;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import BaseTest.baseTest;
import DriversFactory.driversFactory;
import PageObjects.ConfirmationPage;
import PageObjects.FlightDeparturePage;
import PageObjects.FlightDetailsPage;
import PageObjects.ItineraryPage;
import PageObjects.RegistrationPage;
import Utils.baseUtils;

public class ItineraryTest extends baseTest{
	
	WebDriver driver;
	private	RegistrationPage rpage;
	baseUtils b;
	ConfirmationPage cp;
	FlightDetailsPage fp;
	FlightDeparturePage fd;
	ItineraryPage ip;
	
	//@BeforeClass
	@Test(priority=1)
	public void launchAppAndNavigateToItineraryPage() throws Exception
	{
		rpage = new RegistrationPage(driversFactory.getDriver());
		b = new baseUtils();
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
		ip = fd.continueToItineraryPage();
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
		AssertJUnit.assertEquals(ip.itineraryPageMessage(), "Flight Itinerary Page");
		log.info("Itinerary page is displayed, assertion successfull");
	}
	
	@Test(priority=4)
	public void confirmationID()
	{
		AssertJUnit.assertTrue(!ip.confirmationId().isEmpty());
		log.info("Flight ticket confirmation id fetched ----> "+ip.confirmationId());
	}
	
	@Test(priority=5)
	public void totalTicketPrice()
	{
		AssertJUnit.assertTrue(!ip.totalPrice().isEmpty());
		log.info("Flight ticket price ----> "+ip.totalPrice());
	}
	
	@Test(priority=6)
	public void signOffLink()
	{
		AssertJUnit.assertTrue(ip.signOffButton());
		log.info("sign off link enabled, user signed off successfully ----> ");
	}
}
