package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseTest.baseTest;

public class ExtentListeners extends baseTest implements ITestListener{

	
	ExtentSparkReporter sparkReporter;  // this is class
	ExtentReports report;			// class 
	ExtentTest test;					// class
	String reportName = "/Users/vaibhavsrivastava/eclipse-workspace/SeleniumUIDocker/reports" +"ExtentTestReport" + "_"+ System.currentTimeMillis()+".html";
	
	public void configureExtentReport()
	{
		sparkReporter = new ExtentSparkReporter(reportName);
		report = new ExtentReports();
		
		report.attachReporter(sparkReporter);
		report.setSystemInfo("Machine", "Macbook Air M1");
		report.setSystemInfo("OS", "MacOS");
		report.setSystemInfo("QA Tester", "Vaibhav Srivastava");
		
		sparkReporter.config().setDocumentTitle("UI Test Automation");
		sparkReporter.config().setReportName("Report Name via sparkereporter--->"+reportName);
		sparkReporter.config().setTheme(Theme.DARK);
		
	}
	@Override
	public void onStart(ITestContext context) {
		configureExtentReport();
		test.info("Test Execution initiated---->" +context.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getName());
		test = test.log(Status.PASS,MarkupHelper.createLabel("Test case passed---->" +result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getName());
		test = test.log(Status.FAIL,MarkupHelper.createLabel("Test case failed---->" +result.getName(), ExtentColor.ORANGE));
	}


	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		test.info("Test Execution done---->" +context.getName());
	}

	
	
}
