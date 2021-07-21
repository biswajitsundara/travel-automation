package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.util.DataService;
import framework.util.Reusables;

/**
 * 
 * @author Biswajit Sundara
 * @date 21/07/2021
 *
 */

public class FlightPage {

	private Reusables reusable;
	private DataService commonDataService;

	public FlightPage(WebDriver driver, String testcaseName){
		reusable = new Reusables(driver);
		commonDataService = new DataService(this.getClass().getSimpleName().toString());
	}

	public static final By flightsMsg = By.xpath("//div[@class=\"container\"]/h3");
	public static final By btnChooseFlight = By.xpath("//input[@value='Choose This Flight']");
	private static final By tableLocator = By.xpath("//table");

	public boolean flightsDisplayed() {

		String heading = commonDataService.getStringValue("headingFirst");
		if(reusable.getElementText(flightsMsg).startsWith(heading)) {
			return true;
		}

		return false;
	}

	public void selectFirstFlight() {
		reusable.clickElementByIndex(btnChooseFlight, 1);
	}

	public String getFirstFlightAirline() {
		return reusable.getCellValue(tableLocator, 1, "Airline");
	}


}
