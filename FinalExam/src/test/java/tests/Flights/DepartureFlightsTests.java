package tests.Flights;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DepartureFlightsPage;
import pages.SearchFlightScreen;
import tests.Base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class DepartureFlightsTests extends BaseTest {

    SearchFlightScreen searchFlightPage;

    @Test
    public void verifySideBarInformationTestDeparture() throws InterruptedException {
        DepartureFlightsPage departureFlightsPage;
        List<WebElement> allFlightsList;
        searchFlightPage = homePage.clickOnSearchButton();
        searchFlightPage.selectFromDropDown("Duration (Shortest)");
        allFlightsList = searchFlightPage.getFlightsList();
        departureFlightsPage  = searchFlightPage.clickOnFirstDepartureFlight(allFlightsList, 0);
        Assert.assertEquals(departureFlightsPage.getDepartureFlightTimeSidebar(), "10:45am - 11:57am",
                "Selector does not match with the estimated time of the flight");
    }
    //Add parameters to send the time and add the error when assert fails

    @Test
    public void verifySideBarInformationTestArrival() throws InterruptedException {
        DepartureFlightsPage departureFlightsPage;
        List<WebElement> allFlightsList;
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
        Assert.assertEquals(departureFlightsPage.getDepartureFlightTimeSidebar(), "8:20pm - 9:30pm",
               "Selector does not match with the estimated time of the flight");
    }
}
