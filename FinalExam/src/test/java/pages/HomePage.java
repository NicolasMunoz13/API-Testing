package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private WebDriver driver;

    @FindBy(xpath = "//a//span[text()=\"Flights\"]")
    private WebElement flightsButton;

    //@FindBy(xpath = "//div[@title=\"Leaving from\"]")
    @FindBy(id = "location-field-leg1-origin-menu")
    private WebElement departureInputField;

    @FindBy(id = "location-field-leg1-origin")
    private WebElement inputDepartureTextField;

    @FindBy(id = "location-field-leg1-destination-menu")
    private WebElement destinationInputField;

    @FindBy(id = "location-field-leg1-destination")
    private WebElement inputDestinationTextField;

    @FindBy(xpath = "//button[@data-testid=\"travelers-field\"]")
    private WebElement travelersFieldButton;

    @FindBy(xpath = "//div[@id=\"adaptive-menu\"]//div[1]//section//div[1]//div[1]//div//button[2]")
    private WebElement adultsIncrementButton;

    @FindBy(xpath = "//button[text()=\"Done\"]")
    private WebElement doneButton;

    @FindBy(xpath = "//div[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]")
    private WebElement departingDatePicker;

    @FindBy(xpath = "//button[@aria-label=\"Mar 30, 2022\"]")
    private WebElement selectedDepartureDate;

    @FindBy(xpath = "//button[@data-stid=\"date-picker-paging\"][2]")
    private WebElement arrowKey;

    @FindBy(xpath = "//button[@aria-label=\"May 30, 2022\"]")
    private WebElement selectedArrivalDate;

    @FindBy(xpath = "//button[@data-stid=\"apply-date-picker\"]")
    private WebElement doneDatePickerButton;

    @FindBy(xpath = "//button[text()=\"Search\"]")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnDepartureInputField(){
        departureInputField.click();
    }

    public void sendInputText(String city, Keys keyEnter){
        inputDepartureTextField.sendKeys(city);
        inputDepartureTextField.sendKeys(keyEnter);
    }

    public void clickOnDestinationInputField(){
        destinationInputField.click();
    }

    public void sendInputDestinationText(String city, Keys keyEnter){
        inputDestinationTextField.sendKeys(city);
        inputDestinationTextField.sendKeys(keyEnter);
    }

    public void pickOnTravelersFieldButton(){

    }

    public void clickToIncrementTravelerButton(){
        travelersFieldButton.click();
        adultsIncrementButton.click();
        doneButton.click();
    }

    public void selectDates(){
        departingDatePicker.click();
        waitWebElementToBeClickable(driver, selectedDepartureDate, 5);
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //ext.until(ExpectedConditions.elementToBeClickable(selectedDepartureDate));
        selectedDepartureDate.click();
        arrowKey.click();
        selectedArrivalDate.click();
        doneDatePickerButton.click();
    }

    public SearchFlightScreen clickOnSearchButton(){
        searchButton.click();
        return new SearchFlightScreen(driver);
    }

    public void clickOnFlightsButton(){
        flightsButton.click();
    }
}
