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

public class ReservationPage {

	private Reusables reusable;
	private DataService dataService;
	private DataService commonDataService;


	public ReservationPage(WebDriver driver, String testcaseName){
		reusable = new Reusables(driver);
		dataService = new DataService(this.getClass().getSimpleName().toString(),testcaseName);	
		commonDataService = new DataService(this.getClass().getSimpleName().toString());
	}

	public static final By reservedMessage = By.xpath("//div[@class=\"container\"]/h2");
	public static final By airLineName = By.xpath("//div[@class='container']/p[1]");
	public static final By custName = By.id("inputName");
	public static final By address = By.id("address");
	public static final By city = By.id("city");
	public static final By state = By.id("state");
	public static final By zipCode = By.id("zipCode");
	public static final By cardType = By.id("cardType");
	public static final By cardNumber = By.id("creditCardNumber");
	public static final By cardMonth = By.id("creditCardMonth");
	public static final By cardYear = By.id("creditCardYear");
	public static final By nameOnCard = By.id("nameOnCard");
	public static final By btnPurchaseFlight = By.xpath("//input[@value='Purchase Flight']");

	public boolean flightReserved() {
		if(reusable.getElementText(reservedMessage).contains(commonDataService.getStringValue("partialHeading"))){
			return true;
		}
		return false;
	}

	public String getAirline() {
		return reusable.getElementText(airLineName);
	}

	public void fillPersonalDetails() {
		reusable.enterText(custName, dataService.getStringValue("name"));
		reusable.enterText(address, dataService.getStringValue("address"));
		reusable.enterText(city, dataService.getStringValue("city"));
		reusable.enterText(state, dataService.getStringValue("state"));
		reusable.enterText(zipCode, dataService.getStringValue("zipcode"));
	}

	public void fillCardDetails() {
		reusable.selectFromDropDown(cardType, dataService.getStringValue("cardType"));
		reusable.enterText(cardNumber, dataService.getStringValue("creditcard"));
		reusable.enterText(cardMonth, dataService.getStringValue("month"));
		reusable.enterText(cardYear, dataService.getStringValue("year"));
		reusable.enterText(nameOnCard, dataService.getStringValue("nameoncard"));
	}
	
	public void purchaseFlight() {
		reusable.clickElement(btnPurchaseFlight);
	}

}
