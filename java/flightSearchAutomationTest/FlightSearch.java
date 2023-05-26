package flightSearchAutomationTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import flightSearchAutomationPages.EnteringFlightDetails;
import flightSearchAutomationPages.PrintingFlightDetails;
import flightSearchAutomationPages.ReportsGen;

@Listeners(ReportsGen.class)
public class FlightSearch {
	WebDriver driver;
	EnteringFlightDetails detailsObject;
	PrintingFlightDetails availableFlightsObject;

	@BeforeTest
	public void LaunchTheBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagmanasa\\Desktop\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.air.irctc.co.in/");
		String title = driver.getTitle();
		Assert.assertTrue(true, title);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		detailsObject = new EnteringFlightDetails(driver);
		availableFlightsObject = new PrintingFlightDetails(driver);
	}

	@Test(priority = 2)
	public void testDetails() throws InterruptedException {

		detailsObject.ClickOnOrigin("hyd");

		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void testPopup() throws InterruptedException {
		Thread.sleep(5000);
		detailsObject.ClickOnPopup();

	}

	@Test(priority = 3)
	public void testHyd() throws InterruptedException {

		detailsObject.ClickOnHyd();
		Thread.sleep(2000);

	}

	@Test(priority = 4)
	public void testDestination() throws InterruptedException {

		detailsObject.ClickOnDestination("pun");
		Thread.sleep(2000);

	}

	@Test(priority = 5)
	public void testPune() throws InterruptedException {

		detailsObject.ClickOnPune();
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void testDeparture() throws InterruptedException {

		detailsObject.ClickOnDeparture();
		Thread.sleep(2000);
	}

	@Test(priority = 7)
	public void testDate() throws InterruptedException {

		detailsObject.ClickOnDate();
		Thread.sleep(500);

	}

	@Test(priority = 8)
	public void testTraveller() throws InterruptedException {

		detailsObject.ClickOnTraveller();
		Thread.sleep(2000);

	}

	@Test(priority = 9)
	public void testEconomy() throws InterruptedException {

		detailsObject.ClickOnEconomy();
		Thread.sleep(2000);
	}

	@Test(priority = 10)
	public void testSearch() throws InterruptedException {

		detailsObject.ClickOnSearch();
		Thread.sleep(2000);

	}

	@Test(priority = 11)
	public void testCheckDetails() throws InterruptedException {

		availableFlightsObject.CheckingDetails();

	}

	@Test(priority = 12)
	public void testFlightDetails() throws InterruptedException {

		availableFlightsObject.printingAvailFlights();

	}

	@Test(priority = 13)
	public void CapturingScreenshot() throws IOException, InterruptedException {
		TakesScreenshot capture = (TakesScreenshot) driver;
		File scrFile = capture.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\nagmanasa\\Desktop\\Project\\capture.png");
		FileUtils.copyFile(scrFile, target);
		availableFlightsObject.CaptureScreenshot();
		Thread.sleep(1000);
		File scrFile1 = capture.getScreenshotAs(OutputType.FILE);
		File target1 = new File("C:\\Users\\nagmanasa\\Desktop\\Project\\capture1.png");
		FileUtils.copyFile(scrFile1, target1);
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
