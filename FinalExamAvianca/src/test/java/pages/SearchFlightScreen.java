package pages;

import org.openqa.selenium.WebDriver;

public class SearchFlightScreen extends BasePage{

    private WebDriver driver;

    public SearchFlightScreen(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
