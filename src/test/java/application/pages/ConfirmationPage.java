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
public class ConfirmationPage {

	private Reusables reusable;
	private DataService commonDataService;


	public ConfirmationPage(WebDriver driver){
		reusable = new Reusables(driver);
		commonDataService = new DataService(this.getClass().getSimpleName().toString());	
	}

	public static final By confMessage = By.xpath("//div[@class='container hero-unit']/h1");
	public static final By bookingId = By.xpath("//table/tbody/tr[1]/td[2]");
	public static final By bookingStatus = By.xpath("//table/tbody/tr[2]/td[2]");
	public static final By bookingAmount = By.xpath("//table/tbody/tr[3]/td[2]");
	public static final By bookingDate = By.xpath("//table/tbody/tr[7]/td[2]");

	public boolean bookingConfirmed() {

		if(reusable.getElementText(confMessage).contentEquals(commonDataService.getStringValue("heading"))){
			return true;
		}
		return false;
	}

	public String getBookingId() {
		return reusable.getElementText(bookingId);
	}

	public void printBookingDetails(){

		System.out.println("*********************** Booking Details *******************************");
		System.out.println("Booking Id= " +reusable.getElementText(bookingId));
		System.out.println("Booking Status = " +reusable.getElementText(bookingStatus));
		System.out.println("Booking Amount = " +reusable.getElementText(bookingAmount));
		System.out.println("Booking Date = " +reusable.getElementText(bookingDate));
	}

}
