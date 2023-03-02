package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightPage extends BasePage{

    private WebDriver driver;

    public FlightPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[1]/div/div[1]")
    private WebElement leavingFromButton;

    public void sendLeavingFrom(){
        leavingFromButton.click();
    }
}
