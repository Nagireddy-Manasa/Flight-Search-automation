package flightSearchAutomationPages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PrintingFlightDetails {
	By CheckingDetailsHyd = By.xpath("//div[@class='right-searchbarbtm-in']//div[2]//span[text()='Hyderabad (HYD)']");
	By CheckingDetailsPune = By.xpath("//div[@class='right-searchbarbtm-in']//div[3]//span[text()='Pune (PNQ)']");
	By CheckingDetailsDate = By.xpath("//a[@tabindex='0']//span[text()='Mon, 29 May']");
	By Table = By.xpath("//div[@class='col-12 col-md-9 right-searchbar']");
	By Flight = By.className("right-searchbarbtm");
	By flightName = By.className("right-searchbarbtm-in");

	WebDriver driver;

	public PrintingFlightDetails(WebDriver driver) {
		this.driver = driver;

	}

	public void CheckingDetails() {
		WebElement Hyderabad = driver.findElement(CheckingDetailsHyd);
		WebElement Pune = driver.findElement(CheckingDetailsPune);
		WebElement Date = driver.findElement(CheckingDetailsDate);
		if (CheckingDetailsHyd.equals(Hyderabad) && CheckingDetailsPune.equals(Pune)
				&& CheckingDetailsDate.equals(Date)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
	}

	public void printingAvailFlights() {
		WebElement rows = driver.findElement(Table);
		List<WebElement> row = rows.findElements(Flight);
		System.out.println("No of flights are " + row.size());
		for (WebElement name : row) {
			String availableFlights = name.findElement(flightName).getText();
			System.out.println("Flight name: " + availableFlights);
		}
	}

	public boolean CaptureScreenshot() {
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 500).build().perform();
		return true;
	}

}
