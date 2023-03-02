package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public FlightPage selectFlightHotelPage(){
        clickLink("Flights");
        return new FlightPage(driver);
    }

}
