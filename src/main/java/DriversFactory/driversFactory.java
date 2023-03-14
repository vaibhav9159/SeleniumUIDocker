package DriversFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import ConfigReader.ConfigFileReader;

public class driversFactory {

//	String execution = "local";
//	String completeurl = "http://localhost:4444/wd/hub";
	
	ConfigFileReader reader;
	Properties prop ;
	 MutableCapabilities mc ;
	 DesiredCapabilities dc;
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver> ();
	
	
	public WebDriver initializeDriver(String browser, String appUrl, String gridURL,String executionMode) throws Exception
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		reader = new ConfigFileReader();
		
		switch (browser.toLowerCase())
		{
		case "chrome": 
//			dc = new DesiredCapabilities();
//			dc.setCapability("browsername", browser);
//			driver = new RemoteWebDriver(new URL(completeurl), dc);
	
			switch(executionMode)
			{
			case "grid":
				mc = new ChromeOptions();
				driver = new RemoteWebDriver(new URL(gridURL), mc);
				tdriver.set(driver);
			break;
			case "local":
				ChromeOptions ops = new ChromeOptions();		// addded to resolve latest bug of selenium with chrome version 111
			//	ops.addArguments("--remote-allow-origins=*");
			//	ops.addArguments("--headless");
				
				driver = new ChromeDriver(ops);
				tdriver.set(driver);
			break;
			default : System.out.println("select valid execution type value");
			}
			
		break;
		
		
		case "chromeheadless":
			switch(executionMode)
			{
			case "grid":
				mc = new ChromeOptions();
				driver = new RemoteWebDriver(new URL(gridURL), mc);
				tdriver.set(driver);
			break;
			case "local":
				ChromeOptions ops = new ChromeOptions();		// addded to resolve latest bug of selenium with chrome version 111
			//	ops.addArguments("--remote-allow-origins=*");
				ops.addArguments("--headless");
				
				driver = new ChromeDriver(ops);
				tdriver.set(driver);
			break;
			default : System.out.println("select valid execution type value");
			}
			
		break;
		
		
		case "firefox":
			
			switch(executionMode)
			{
			case "grid":
				mc = new FirefoxOptions();
				driver = new RemoteWebDriver(new URL(gridURL), mc);
				tdriver.set(driver);
			break;
			case "local":
				FirefoxOptions f = new FirefoxOptions();	
			//	f.addArguments("--headless");	
			//	opsl.addArguments("--remote-allow-origins=*");// addded to resolve latest bug of selenium with chrome version 111
				driver = new FirefoxDriver();
				tdriver.set(driver);
			break;
			default : System.out.println("select valid execution type value");
			}
			
		break;
		
		
		case "safari":
			
			switch(executionMode)
			{
			case "grid":
				mc = new SafariOptions();
				driver = new RemoteWebDriver(new URL(gridURL), mc);
				tdriver.set(driver);
			break;
			case "local":
				SafariOptions f = new SafariOptions();	
				driver = new SafariDriver();
				tdriver.set(driver);
			break;
			default : System.out.println("select valid execution type value");
			}
			
		break;
		
		default : System.out.println("enter valid browser value");
		}
		
		getDriver().manage().window().maximize();
		getDriver().get(appUrl);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
	}
	
	public void captureScreenshot() throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/target/screenshots/"+ "test"+"_"+ System.currentTimeMillis()+ ".png";
		FileUtils.copyFile(src, new File(destination));
	//	return destination ;
	}
}
