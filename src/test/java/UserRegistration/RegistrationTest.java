package UserRegistration;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
import PageObjects.RegistrationPage;
import Utils.baseUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RegistrationTest extends baseTest{
	
	WebDriver driver;
	RegistrationPage rpage;
	Properties prop;
	ConfigFileReader r;
	baseUtils b;
	
	@Test(priority=1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Launch Application step for user registration")
	public void launchApplication() throws Exception
	{
		rpage = new RegistrationPage(driversFactory.getDriver());
		b = new baseUtils();
	//	driver = driversFactory.getDriver();
		log.info("thread--->" +Thread.currentThread().getId());
	}
	
	@Test(priority=2)
	public void validatePageTitle()
	{
		AssertJUnit.assertEquals(rpage.pageTitle(),"Flight Booking Form");
	}
	
	@Test(priority=3)
	public void registerUser()
	{
		rpage.enterfirstname(b.firstName());
		rpage.enterlastname(b.lastName());
		rpage.enterphone(b.phone());
		rpage.enteremail(b.email());
		rpage.selectCountry(b.country());
		rpage.userName(b.userName());
		rpage.password(b.password());
		rpage.confirmPassword(b.confirmPassword());
	//	rpage.submit();
		
		log.info("user registration data added successfully");
	}
	
}
