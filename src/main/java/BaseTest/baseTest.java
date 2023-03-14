package BaseTest;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ConfigReader.ConfigFileReader;
import DriversFactory.driversFactory;

public class baseTest {

	public ConfigFileReader reader;
	protected driversFactory factory;
	private Properties prop ;
	protected WebDriver driver;
	public Logger log;
	
	public baseTest()
	{
		log = LogManager.getLogger(getClass().getName());
		
	}
	
	@BeforeClass(alwaysRun=true)
	public void launchBrowser() throws Exception
	{
		reader = new ConfigFileReader();
		prop = reader.initializePropFile();
		String browser = System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		String url = prop.getProperty("url");
	//	String browser = "chrome";
		String executionMode = prop.getProperty("execution");
		String gridURL = prop.getProperty("completeurl");
		log.info("browser ---->" + browser);
		log.info("url launched ---->" + url);
		log.info("execution Mode  ---->" + executionMode + " grid url ---->" + gridURL);
		factory = new driversFactory();
		driver = factory.initializeDriver(browser,url,gridURL, executionMode);

	}
	
	
	public String captureScreenshot() throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/target/screenshots/"+ "test_"+ System.currentTimeMillis()+ ".png";
		FileUtils.copyFile(src, new File(destination));
		return destination ;
	}
	
	public void waitForElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void waitForElementCount(WebDriver driver,By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		
	}
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		log.info("quiting browser");
		driver.close();
		driver.quit();
	}		
}
