package application.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import application.pages.ConfirmationPage;
import application.pages.FlightPage;
import application.pages.HomePage;
import application.pages.ReservationPage;
import framework.base.DriverFactory;

/**
 * 
 * @author Biswajit Sundara
 * @date 21/07/2021
 *
 */
public class TC001_Flight_Booking_Test extends BaseTest{

	
	HomePage homePage;
	FlightPage flightPage;
	ReservationPage reservationPage;
	ConfirmationPage confirmationPage;
	
	String selectedAirline;
	

	@Test
	public void TC001_Flight_Booking() {
		
		String testname = this.getClass().getSimpleName();
		
		homePage = new HomePage(DriverFactory.getDriver(),testname);
		Assert.assertTrue(homePage.homePageDisplayed());
		homePage.selectDepartureCity();
		homePage.selectDestinationCity();
		homePage.clickFindFlights();
		
		flightPage = new FlightPage(DriverFactory.getDriver(),testname);
		Assert.assertTrue(flightPage.flightsDisplayed());
		selectedAirline = flightPage.getFirstFlightAirline();
		flightPage.selectFirstFlight();
		System.out.println("Selected Airline" +selectedAirline);
		
		reservationPage = new ReservationPage(DriverFactory.getDriver(),testname);
		Assert.assertTrue(reservationPage.flightReserved());
		reservationPage.flightReserved();
		reservationPage.fillPersonalDetails();
		reservationPage.fillCardDetails();
		reservationPage.purchaseFlight();
		
		confirmationPage = new ConfirmationPage(DriverFactory.getDriver());
		Assert.assertTrue(confirmationPage.bookingConfirmed());
		Assert.assertNotNull(confirmationPage.getBookingId());
		
		confirmationPage.printBookingDetails();
			
	}
	
}
