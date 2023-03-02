package tests.Flights;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DepartureFlightsPage;
import pages.SearchFlightScreen;
import pages.PassengerInformation;
import tests.Base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class TripDetailsTests extends BaseTest {

    SearchFlightScreen searchFlightPage;
    DepartureFlightsPage departureFlightsPage;

    @Test
    public void verifyTripTotalPriceDetailsTest() throws InterruptedException {;
        List<WebElement> allFlightsList;
        ArrayList<Boolean> tripInformationAssertList;
        searchFlightPage = homePage.clickOnSearchButton();
        searchFlightPage.selectFromDropDown("Duration (Shortest)");
        allFlightsList = searchFlightPage.getFlightsList();
        departureFlightsPage  = searchFlightPage.clickOnFirstDepartureFlight(allFlightsList, 0);
        departureFlightsPage.getDepartureFlightTimeSidebar();
        departureFlightsPage.clickOnSelectButton();
        searchFlightPage.selectFromDropDown("Duration (Shortest)");
        allFlightsList = searchFlightPage.getFlightsList();
        departureFlightsPage  = searchFlightPage.clickOnFirstDepartureFlight(allFlightsList, 2);
        departureFlightsPage.clickOnSelectButton();
        tripInformationAssertList = departureFlightsPage.getTravelInformation();
        System.out.println(tripInformationAssertList.get(0));
        Assert.assertTrue(tripInformationAssertList.get(0));
    }

    @Test
    public void verifyTripDepartureDetailsTest() throws InterruptedException {;
        List<WebElement> allFlightsList;
        ArrayList<Boolean> tripInformationAssertList;
        searchFlightPage = homePage.clickOnSearchButton();
        searchFlightPage.selectFromDropDown("Duration (Shortest)");
        allFlightsList = searchFlightPage.getFlightsList();
        departureFlightsPage  = searchFlightPage.clickOnFirstDepartureFlight(allFlightsList, 0);
        departureFlightsPage.getDepartureFlightTimeSidebar();
        departureFlightsPage.clickOnSelectButton();
        searchFlightPage.selectFromDropDown("Duration (Shortest)");
        allFlightsList = searchFlightPage.getFlightsList();
        departureFlightsPage  = searchFlightPage.clickOnFirstDepartureFlight(allFlightsList, 2);
        departureFlightsPage.clickOnSelectButton();
        tripInformationAssertList = departureFlightsPage.getTravelInformation();
        System.out.println(tripInformationAssertList.get(1));
        Assert.assertTrue(tripInformationAssertList.get(1));
    }

    @Test
    public void verifyTripFareDetailsTest() throws InterruptedException {;
        List<WebElement> allFlightsList;
        ArrayList<Boolean> tripInformationAssertList;
        searchFlightPage = homePage.clickOnSearchButton();
        searchFlightPage.selectFromDropDown("Duration (Shortest)");
        allFlightsList = searchFlightPage.getFlightsList();
        departureFlightsPage  = searchFlightPage.clickOnFirstDepartureFlight(allFlightsList, 0);
        departureFlightsPage.getDepartureFlightTimeSidebar();
        departureFlightsPage.clickOnSelectButton();
        searchFlightPage.selectFromDropDown("Duration (Shortest)");
        allFlightsList = searchFlightPage.getFlightsList();
        departureFlightsPage  = searchFlightPage.clickOnFirstDepartureFlight(allFlightsList, 2);
        departureFlightsPage.clickOnSelectButton();
        tripInformationAssertList = departureFlightsPage.getTravelInformation();
        System.out.println(tripInformationAssertList.get(2));
        Assert.assertTrue(tripInformationAssertList.get(2));
    }
}
