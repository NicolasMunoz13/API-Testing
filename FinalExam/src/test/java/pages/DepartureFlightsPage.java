package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Set;

public class DepartureFlightsPage extends BasePage{

    private WebDriver driver;

    PassengerInformation tripDetailsPage;

    ArrayList<Boolean> tripInformationResultsInList;

    private By tripTotalText = By.cssSelector(".uitk-table-foot");

    private By departureTextInPage = By.xpath("//h2[text()=\"Las Vegas to Los Angeles\"]");

    private By fareTextInPage = By.xpath("//h3[text()=\"Fare: Economy\"]");

    @FindBy(xpath = "//div[@data-test-id=\"flight-summary\"]//h3//span")
    private WebElement departureAndArrivalTime;

    @FindBy(xpath = "//button[text()=\"Select\"]")
    private WebElement selectButton;

    @FindBy(css = ".uitk-table-foot")
    private WebElement tripTotalLabel;

    @FindBy(xpath = "//h2[text()=\"Las Vegas to Los Angeles\"]")
    private WebElement departureLabel;

    @FindBy(xpath = "//h2[text()=\"Los Angeles to Las Vegas\"]")
    private WebElement arrivalLabel;

    @FindBy(xpath = "//h3[text()=\"Fare: Economy\"]")
    private WebElement fareEconomyLabel;

    @FindBy(xpath = "//button[text()=\"Check out\"]")
    private WebElement checkOutButton;

    public DepartureFlightsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getDepartureFlightTimeSidebar(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.visibilityOf(departureAndArrivalTime));
        String departureAndArrivalLabel = departureAndArrivalTime.getText();

        return departureAndArrivalLabel;
    }

    public void clickOnSelectButton(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(selectButton));
        selectButton.click();
    }

    public ArrayList<Boolean> getTravelInformation(){
        String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        tripInformationResultsInList = new ArrayList<>();
        for(String windowHandle:handles){
            if(!windowHandle.equals(parentWindow))
            {
                driver.switchTo().window(windowHandle);
                tripInformationResultsInList.add(isTripTotalDisplayed());
                tripInformationResultsInList.add(isDepartureAndArrivalDisplayed());
                tripInformationResultsInList.add(isFareDisplayed());
            }
        }
        return tripInformationResultsInList;
    }

    public boolean isTripTotalDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.presenceOfElementLocated(tripTotalText));
        boolean tripTotalPriceLabel = tripTotalLabel.isDisplayed();
        return tripTotalPriceLabel;
    }

    public boolean isDepartureAndArrivalDisplayed(){
        boolean tripDepartureAndArrivalAreInformation;
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.presenceOfElementLocated(departureTextInPage));
        if (departureLabel.isDisplayed() == true && arrivalLabel.isDisplayed() == true){
            tripDepartureAndArrivalAreInformation = true;
        }else {
            tripDepartureAndArrivalAreInformation = false;
        }
        return tripDepartureAndArrivalAreInformation;
    }

    public boolean isFareDisplayed(){
        boolean fareLabel;
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.presenceOfElementLocated(fareTextInPage));
        fareLabel = fareEconomyLabel.isDisplayed();
        return fareLabel;
    }

    public PassengerInformation AddPassengerInformation(){
        String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        tripInformationResultsInList = new ArrayList<>();
        for(String windowHandle:handles){
            if(!windowHandle.equals(parentWindow))
            {
                driver.switchTo().window(windowHandle);
                clickOnCheckOut();
            }
        }
        return new PassengerInformation(driver);
    }

    public PassengerInformation clickOnCheckOut(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        checkOutButton.click();
        return new PassengerInformation(driver);
    }

}
