package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightPage extends BasePage{

    private WebDriver driver;

    public FlightPage (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[1]/div/div[1]")
    private WebElement leavingFromButton;

    @FindBy(css = "#location-field-leg1-origin")
    private WebElement leavingFromInput;

    @FindBy(xpath = "//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[1]/div/div[2]")
    private WebElement goingToButton;

    @FindBy(css = "#location-field-leg1-destination")
    private WebElement goingToInput;

    @FindBy(xpath = "//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]")
    private WebElement departingDatePicker;

    @FindBy(xpath = "//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/button[2]")
    private WebElement arrowKey;

    @FindBy(xpath = "//button[@aria-label=\"Mar 7, 2022\"]")
    private WebElement selectedDate;

    @FindBy(xpath = "//button[@aria-label=\"May 7, 2022\"]")
    private WebElement endDate;

    @FindBy(xpath = "//button[@data-stid=\"apply-date-picker\"]")
    private WebElement doneButton;

    @FindBy(xpath = "//button[@data-testid=\"submit-button\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//section[@data-test-id=\"sortBar\"]")
    private WebElement sortByBox;

    @FindBy(xpath = "//*[@id=\"app-layer-base\"]/div[2]/div[3]/div[1]/aside/fieldset/fieldset[4]/div")
    private WebElement departureGrid;

    @FindBy(xpath = "//*[@id=\"app-layer-base\"]/div[2]/div[3]/div[1]/aside/fieldset/fieldset[5]/div")
    private WebElement arrivalGrid;

    @FindBy(xpath = "//button[@data-test-id=\"select-button\"]")
    private WebElement selectButton;

    @FindBy(xpath = "//button[@data-test-id=\"select-link\"]")
    private WebElement flightSelection;


    public void inputConfirmationEnter(Keys keyEnter){
        leavingFromInput.sendKeys(keyEnter);
    }

    public void inputConfirmationEnterGoingTo(Keys keyEnter){
        goingToInput.sendKeys(keyEnter);
    }

    public void sendLeavingFrom(String leavingCity){
        leavingFromButton.click();
        leavingFromInput.sendKeys(leavingCity);
    }

    public void sendGoingTo(String goingToCity){
        goingToButton.click();
        goingToInput.sendKeys(goingToCity);
    }

    public void selectDepartingDate(){
        departingDatePicker.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        selectedDate.click();
        arrowKey.click();
        arrowKey.click();
        endDate.click();
        doneButton.click();
        searchButton.click();

        /*WebElement dateWidgetFrom = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("uitk-calendar"))).get(0);
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        System.out.println(columns);
        DateUtil.clickGivenDay(columns, DateUtil.getCurrentDay());
        Thread.sleep(5000);*/
    }

    public void selectFlight(By webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement flightsDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
    }

    public boolean sortFlights(){
        selectFlight(By.xpath("//section[@data-test-id=\"sortBar\"]"));
        return sortByBox.isDisplayed();
    }

    public boolean departureVisible(){
        selectFlight(By.xpath("//*[@id=\"app-layer-base\"]/div[2]/div[3]/div[1]/aside/fieldset/fieldset[4]/div"));
        return departureGrid.isDisplayed();
    }

    public boolean arrivalVisible(){
        selectFlight(By.xpath("//*[@id=\"app-layer-base\"]/div[2]/div[3]/div[1]/aside/fieldset/fieldset[5]/div"));
        return arrivalGrid.isDisplayed();
    }

    public List<WebElement> flightListInformation(){
        List<WebElement> listOfFlights = driver.findElements(By.xpath("//button[@data-test-id=\"select-link\"]"));
        System.out.println(listOfFlights.size());
        for (WebElement element:listOfFlights) {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test-id=\"select-link\"]")));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-icon=\"tool-close\"]")));
            driver.findElement(By.xpath("//button[@data-icon=\"tool-close\"]")).click();
        }
        return listOfFlights;
    }

    public void clickOnFirstFlight(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-test-id=\"select-link\"]")));
        flightSelection.click();
    }

    public void clickOnThirdFlight(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-test-id=\"select-link\"]")));
        WebElement thirdFlight = driver.findElement(By.xpath("//button[@data-test-id=\"select-link\"]"));
        List<WebElement> listOfFlights = driver.findElements(By.xpath("//button[@data-test-id=\"select-link\"]"));
        System.out.println(listOfFlights.size());
        for (int i = 0; i < listOfFlights.size(); i++) {
            thirdFlight = listOfFlights.get(2);
        }
        thirdFlight.click();
    }

    public void clickToDepartureFlight(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test-id=\"select-button\"]")));
        selectButton.click();
    }

    @FindBy(xpath = "//button[@data-test-id=\"goto-checkout-button\"]")
    private WebElement checkoutButton;

    public void setCheckOut(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test-id=\"goto-checkout-button\"]")));
        checkoutButton.click();
    }

    public DeparturePage setDeparture(){
        return new DeparturePage(driver);
    }

}
