package tests.Flights;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchFlightScreen;
import tests.Base.BaseTest;

import java.util.ArrayList;

public class SearchFlightsTests extends BaseTest {

    SearchFlightScreen searchFlightPage;

    @Test
    public void verifyComboBoxTest(){
        searchFlightPage = homePage.clickOnSearchButton();
        Assert.assertTrue(searchFlightPage.isComboBoxDisplayed(), "true");
    }

    @Test
    public void verifyPriceInEveryResultTest(){
        searchFlightPage = homePage.clickOnSearchButton();
        Assert.assertTrue(searchFlightPage.checkPriceLabelDisplayed(), "true");
    }

    @Test
    public void verifyTimeInEveryResulTest(){
        searchFlightPage = homePage.clickOnSearchButton();
        Assert.assertTrue(searchFlightPage.checkTimeFlightDisplayed(), "true");
    }

    @Test
    public void verifyDestinationAndDepartureTest(){
        searchFlightPage = homePage.clickOnSearchButton();
        Assert.assertEquals(searchFlightPage.checkDepartureAndDestination(), "Las Vegas to Los Angeles", "Incorrect text");
    }

    @Test
    public void verifyFlightAirlineTest(){
        searchFlightPage = homePage.clickOnSearchButton();
        Assert.assertTrue(searchFlightPage.checkFlightAirLinetDisplayed(), "true");
    }

    @Test
    public void verifyFlightListWasSorted() throws InterruptedException {
        ArrayList<Integer> fullFlightsPriceFoundList;
        int firstLeastFlightTimeSorted;
        int firstLeastFlightTimeNotSorted;
        searchFlightPage = homePage.clickOnSearchButton();
        searchFlightPage.selectFromDropDown("Duration (Shortest)");
        fullFlightsPriceFoundList = searchFlightPage.getPriceFlightsList(searchFlightPage.getFlightsList());
        firstLeastFlightTimeSorted = searchFlightPage.getPriceFlightsListSorted(fullFlightsPriceFoundList).get(0);
        firstLeastFlightTimeNotSorted = searchFlightPage.getFirstPriceFlightSorted(fullFlightsPriceFoundList);
        Assert.assertEquals(firstLeastFlightTimeNotSorted, firstLeastFlightTimeSorted, "List is not correctly sorted in ascending order");
    }
}
