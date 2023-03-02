package flights;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.DeparturePage;
import pages.FlightPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FlightsTests extends BaseTests {

    WebDriver driver = new HtmlUnitDriver();

    @Test
    public void setInformationlights(){
        var flightPage = homePage.clickFlightsSelection();
        var departurePage =  flightPage.setDeparture();
        flightPage.sendLeavingFrom("Las Vegas (LAS - All Airports)");
        flightPage.inputConfirmationEnter(Keys.ENTER);
        flightPage.sendGoingTo("Los Angeles Intl. (LAX)");
        flightPage.inputConfirmationEnterGoingTo(Keys.ENTER);
        flightPage.selectDepartingDate();

        assertTrue(flightPage.sortFlights(), "true");
        assertTrue(flightPage.departureVisible(), "true");
        assertTrue(flightPage.arrivalVisible(), "true");

        //flightPage.flightListInformation();
        flightPage.clickOnFirstFlight();
        flightPage.clickToDepartureFlight();
        flightPage.clickOnThirdFlight();
        flightPage.clickToDepartureFlight();

        //departurePage.setCheckOut();
        flightPage.setCheckOut();

    }

}
