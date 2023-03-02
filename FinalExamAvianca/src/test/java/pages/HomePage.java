package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    private WebDriver driver;

    @FindBy(xpath = "//div[@class=\"content-text\"]//a[@data-ancla=\"ancla\"]")
    private WebElement closePopUpButton;

    @FindBy(name = "cookies-confirm")
    private WebElement cookiesButton;

    @FindBy(xpath = "//div[@class=\"row\"]//div[@data-booking=\"home\"]")
    private WebElement departureInputField;

    @FindBy(xpath = "//div[@class=\"row\"]//div[@class=\"x-plugin\"]//input[@data-msg=\"Select city of origin\"]")
    private WebElement departureFormField;

    @FindBy(xpath = "//div[@class=\"row\"]//div[@data-source=\"destination\"]")
    private WebElement destinationInputField;

    @FindBy(xpath = "//div[@class=\"row\"]//div[@class=\"x-plugin\"]//input[@data-msg=\"Select a destination\"]")
    private WebElement destinationFormField;

    @FindBy(xpath = "//div[contains(@id,'ida_regreso')]//div[@class=\"row-input right\"]//div[contains(@class,\"new-container\")]")
    private WebElement departingDatePicker;

    @FindBy(xpath = "//div[contains(@id,'ida_regreso')]//div[@data-day=\"2022.3.31\"]")
    private WebElement selectedDepartureDate;

    @FindBy(xpath = "//div[@class=\"row\"]//div[@class=\"row-input right\"]//input[@aria-label=\"Select the return date\"]")
    private WebElement returnDatePicker;

    @FindBy(xpath = "//div[contains(@id,'ida_regreso')]//div[@data-day=\"2022.5.31\"]")
    private WebElement selectedReturnDate;

    @FindBy(xpath = "//div[contains(@id,'ida_regreso')]//div[@aria-label=\"Next month\"]//em")
    private WebElement nextMonthArrow;

    private By arrow = By.xpath("//div[contains(@id,'ida_regreso')]//div[@aria-label=\"Next month\"]//em");

    @FindBy(xpath = "//div[contains(@id,'ida_regreso')]//input[contains(@id,'pbPasajeros')]")
    private WebElement travelersFieldButton;

    @FindBy(xpath = "//div[contains(@id,'ida_regreso')]//div[@class=\"plus control\"]")
    private WebElement adultsIncrementButton;

    private By incrementButton = By.xpath("//div[contains(@id,'ida_regreso')]//div[@class=\"plus control\"]");

    @FindBy(xpath = "//div[contains(@id,'ida_regreso')]//div[contains(@data-name, \"pbPasajeros\")]//button[text()=\"Continue\"]")
    private WebElement continueButton;

    private By coninueB = By.xpath("//div[contains(@id,'ida_regreso')]//div[contains(@data-name, \"pbPasajeros\")]//button[text()=\"Continue\"]");

    @FindBy(xpath = "//div[contains(@id,'ida_regreso')]//button[text()=\"Search for flights\"]")
    private WebElement searchFlightsButton;

    private By selectDepartureDateLocator = By.xpath("//div[contains(@id,'ida_regreso')]//div[@data-day=\"2022.3.31\"]");

    private By selectReturnDateLocator = By.xpath("//div[contains(@id,'ida_regreso')]//div[@data-day=\"2022.5.31\"]");


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnDepartureInputField(){
        waitWebElementToBeClickable(driver, closePopUpButton, 10);
        closePopUpButton.click();
        cookiesButton.click();
        departureInputField.click();
    }

    public void sendInputText(String city, Keys keyEnter, Keys keyDown){
        departureFormField.sendKeys(city);
        departureFormField.sendKeys(keyDown);
        departureFormField.sendKeys(keyEnter);
    }

    public void clickOnDestinationInputField(){
        waitWebElementToBeClickable(driver, destinationInputField, 10);
        destinationInputField.click();
    }

    public void sendInputDestinationText(String city, Keys keyEnter, Keys keyDown){
        destinationFormField.sendKeys(city);
        destinationFormField.sendKeys(keyDown);
        destinationFormField.sendKeys(keyEnter);
    }

    public void clickToIncrementTravelerButton(){
        travelersFieldButton.click();
        waitWebElementVisibility(driver, incrementButton, 5);
        adultsIncrementButton.click();
        waitWebElementVisibility(driver, coninueB, 5);
        continueButton.click();
    }

    public void selectDatesDeparture() {
        departingDatePicker.click();
        departingDatePicker.click();
        waitWebElementVisibility(driver, selectDepartureDateLocator, 10);
        waitWebElementToBeClickable(driver, selectedDepartureDate, 10);
        selectedDepartureDate.click();
    }

    public void selectReturnDates(){
        returnDatePicker.click();
        returnDatePicker.click();
        nextMonthArrow.click();
        waitWebElementVisibility(driver, selectReturnDateLocator, 5);
        waitWebElementToBeClickable(driver, selectedReturnDate, 5);
        selectedReturnDate.click();
    }

    public SearchFlightScreen clickOnSearchButton(){
        searchFlightsButton.click();
        return new SearchFlightScreen(driver);
    }


}
