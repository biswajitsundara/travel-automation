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

public class HomePage{

	private Reusables reusable;
	private DataService dataService;
	private DataService commonDataService;

	public HomePage(WebDriver driver, String testcaseName){
		reusable = new Reusables(driver);
		dataService = new DataService(this.getClass().getSimpleName().toString(),testcaseName);
		commonDataService = new DataService(this.getClass().getSimpleName().toString());
	}

	public static final By pageHeading = By.xpath("//div[@class=\"container\"]/h1");
	public static final By frmPort = By.name("fromPort");
	public static final By toPort = By.name("toPort");
	public static final By btnFindFlights = By.xpath("//input[@value='Find Flights']");

	public boolean homePageDisplayed() {

		String heading = commonDataService.getStringValue("heading");
		System.out.println(heading);
		
		if(heading.contentEquals(reusable.getElementText(pageHeading))) {
			return true;
		}

		return false;
	}

	public void selectDepartureCity() {
		reusable.selectFromDropDown(frmPort, dataService.getStringValue("from"));
	}

	public void selectDestinationCity() {
		reusable.selectFromDropDown(toPort, dataService.getStringValue("to"));
	}

	public void clickFindFlights() {
		reusable.clickElement(btnFindFlights);
	}

}
