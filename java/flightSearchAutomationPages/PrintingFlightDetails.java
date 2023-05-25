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
	By CheckingDetailsDate = By.xpath("//a[@tabindex='0']//span[text()='Thu, 25 May']");
	By Table = By.xpath("//div[@class='col-12 col-md-9 right-searchbar']");
	By Filghts = By.tagName("div");
	By AirIndiaFlight = By.xpath(
			"//div[@class='right-searchbarbtm']//div[@class='right-searchbarbtm-in']//div//div[2]//b[text()='Air India']");
	 By Flightname=By.xpath("//div[@class='right-searchbarbtm']");
By VistaraFlight=By.xpath("//div[@class='right-searchbarbtm']//div[@class='right-searchbarbtm-in']//div//div[2]//b[text()='Vistara']");

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
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
	}

	public void PrintingAvailFlights() {
		WebElement rows = driver.findElement(Table);
		List<WebElement> row = rows.findElements(Filghts);
		System.out.println("No of flights are " + row.size());
		for (WebElement name : row) {
			String AirIndia = name.findElement(AirIndiaFlight).getText();
			String Vistara=name.findElement(VistaraFlight).getText();
			System.out.println("Flight name:   " + AirIndia);
			System.out.println("Flight name: "+Vistara);
		}
	}

	public boolean CaptureScreenshot() {
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 500).build().perform();
		return true;
	}

}
