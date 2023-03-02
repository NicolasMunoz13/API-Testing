package tests.Flights;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DepartureFlightsPage;
import pages.PassengerInformation;
import pages.SearchFlightScreen;
import tests.Base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class PassengerInformationTests  extends BaseTest {

    SearchFlightScreen searchFlightPage;
    DepartureFlightsPage departureFlightsPage;
    PassengerInformation passengerInformation;

    @Test
    public void addPassengerInformationTest() throws InterruptedException {
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
        passengerInformation = departureFlightsPage.AddPassengerInformation();
        passengerInformation.setUserInformation("Nicolas", "Juan", "Munoz", "3112186259");
        passengerInformation.selectFromDropDown("Colombia +57");
        passengerInformation.clickOnGenderCheckBox("Male");
        passengerInformation.selectBirth("10 - Oct","15","1996");
        passengerInformation.setUserInformationSecondOption("Camilo", "Cas", "Castillo");
        passengerInformation.clickOnGenderCheckBoxSecondOption("Female");
        passengerInformation.selectBirthSecondOption("11 - Nov","15","1994");
        Assert.assertTrue(passengerInformation.isPassengerPriceSummaryDisplayed());
    }

    @Test
    public void ClickOnCompleteBookingInformationTest() throws InterruptedException {
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
        passengerInformation = departureFlightsPage.AddPassengerInformation();
        passengerInformation.setUserInformation("Nicolas", "Juan", "Munoz", "3112186259");
        passengerInformation.selectFromDropDown("Colombia +57");
        passengerInformation.clickOnGenderCheckBox("Male");
        passengerInformation.selectBirth("10 - Oct","15","1996");
        passengerInformation.setUserInformationSecondOption("Camilo", "Cas", "Castillo");
        passengerInformation.clickOnGenderCheckBoxSecondOption("Female");
        passengerInformation.selectBirthSecondOption("11 - Nov","15","1994");
        Assert.assertTrue(passengerInformation.isCompleteBookingButtonDisplayed());
    }

    @Test
    public void insuranceAvailableInformationTest() throws InterruptedException {
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
        passengerInformation = departureFlightsPage.AddPassengerInformation();
        passengerInformation.setUserInformation("Nicolas", "Juan", "Munoz", "3112186259");
        passengerInformation.selectFromDropDown("Colombia +57");
        passengerInformation.clickOnGenderCheckBox("Male");
        passengerInformation.selectBirth("10 - Oct","15","1996");
        passengerInformation.setUserInformationSecondOption("Camilo", "Cas", "Castillo");
        passengerInformation.clickOnGenderCheckBoxSecondOption("Female");
        passengerInformation.selectBirthSecondOption("11 - Nov","15","1994");
        Assert.assertTrue(passengerInformation.isInsuranceAvailable());
    }

    @Test
    public void debitCreditCardTextInformationTest() throws InterruptedException {
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
        passengerInformation = departureFlightsPage.AddPassengerInformation();
        passengerInformation.setUserInformation("Nicolas", "Juan", "Munoz", "3112186259");
        passengerInformation.selectFromDropDown("Colombia +57");
        passengerInformation.clickOnGenderCheckBox("Male");
        passengerInformation.selectBirth("10 - Oct","15","1996");
        passengerInformation.setUserInformationSecondOption("Camilo", "Cas", "Castillo");
        passengerInformation.clickOnGenderCheckBoxSecondOption("Female");
        passengerInformation.selectBirthSecondOption("11 - Nov","15","1994");
        Assert.assertEquals(passengerInformation.getDebitCardText(), "Debit/Credit Card");
    }

    @Test
    public void debitCreditCardTNumberInformationTest() throws InterruptedException {
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
        passengerInformation = departureFlightsPage.AddPassengerInformation();
        passengerInformation.setUserInformation("Nicolas", "Juan", "Munoz", "3112186259");
        passengerInformation.selectFromDropDown("Colombia +57");
        passengerInformation.clickOnGenderCheckBox("Male");
        passengerInformation.selectBirth("10 - Oct","15","1996");
        passengerInformation.setUserInformationSecondOption("Camilo", "Cas", "Castillo");
        passengerInformation.clickOnGenderCheckBoxSecondOption("Female");
        passengerInformation.selectBirthSecondOption("11 - Nov","15","1994");
        Assert.assertTrue(passengerInformation.setDebitCreditCardNumber());
    }
}
