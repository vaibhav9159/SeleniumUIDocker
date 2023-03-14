package Listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseTest.baseTest;
import DriversFactory.driversFactory;

public class ExtentReportGen extends baseTest implements ITestListener{

	ExtentReports report;
	ExtentSparkReporter sparkreporter;
	ExtentTest test;
	public static ThreadLocal<ExtentTest> etest = new ThreadLocal<ExtentTest>();
	
	Date d ;
	SimpleDateFormat s ;
	
	String reportLocation = System.getProperty("user.dir") +"/resources" ;
	String reportName  = "ExtentTestReport.html_"+ System.currentTimeMillis();
	
	public void configureReport()
	{	
		d = new Date();
		s = new SimpleDateFormat("yyyy.mm.dd");
		s.format(s.getDateTimeInstance());
		
		sparkreporter = new ExtentSparkReporter(reportName);
		report = new ExtentReports();
		
		report.attachReporter(sparkreporter);
		
		report.setSystemInfo("OS", "MacOS");
		report.setSystemInfo("Tester", "Vaibhav Srivastava");
		report.setSystemInfo("Machine", "Macbook Air M1");
		
		sparkreporter.config().setDocumentTitle("QA Automation Report");
		sparkreporter.config().setTheme(Theme.DARK);
		
	}


	@Override
	public void onStart(ITestContext context) {
		
		configureReport();
		etest.set(test);
		etest.get().info("Test Execution initiated---->" +context.getName());
	}

	
	@Override
	public void onTestStart(ITestResult result) {
		
		configureReport();
		test  = report.createTest(result.getName());
		etest.set(test);
		etest.get().info("Test Execution initiated---->" +result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test  = report.createTest(result.getName());
		etest.set(test);
		etest.get().log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getName());
		etest.set(test);
		etest.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		etest.get().fail(result.getThrowable());
		
		WebDriver driver = driversFactory.getDriver();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		String filePath = null;
		try {
			filePath = captureScreenshot();
		}
		catch(Exception e)
		{
			
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
		etest.get().info("Test Execution done---->" +context.getName());
	}
	
	
	
	
}
