package flights;

import base.BaseTests;
import org.testng.annotations.Test;

public class FlightsPageTest extends BaseTests {

    @Test
    public void selectFlightInformation(){
        var flightPage = homePage.selectFlightHotelPage();
        flightPage.sendLeavingFrom();

    }
}
