package flightSearchAutomationPages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportsGen implements ITestListener {
	ExtentSparkReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;

	public void onStart(ITestContext context) {
		System.out.println("on start of the test");
		String date = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss-ms").format(new Date());
		reporter = new ExtentSparkReporter("C:\\Users\\nagmanasa\\Desktop\\ProjectReport");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		reporter.config().setDocumentTitle("Flight Search Automation");
		reporter.config().setReportName("Automation selenium+testNG testcases report");
		reporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("Environment", "Selenium+TestNG+java");
		extent.setSystemInfo("Author", "Manasa Nagireddy");
	}

	public void onTestStart(ITestResult result) {
		logger = extent.createTest("Test created for " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS, "The test method passed is " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL, "The test method failed is " + result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		logger.log(Status.SKIP, "The test method skipped is " + result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		logger.log(Status.FAIL, "The test method failed with timeout id  " + result.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("on finish of the test");
		extent.flush();
	}

}
