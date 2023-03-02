package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SearchFlightScreen extends BasePage{

    private WebDriver driver;

    ArrayList<Integer> timeOfFlightsList;
    List<WebElement> listOfFlights;

    @FindBy(id = "listings-sort")
    private WebElement comboBoxDropdown;

    @FindBy(xpath = "//div[@data-test-id=\"listing-details-and-fares\"]//button")
    private WebElement closeIcon;

    @FindBy(xpath = "//ul[@data-test-id=\"listings\"]")
    private WebElement flightsInList;

    @FindBy(xpath = "//button[@data-test-id=\"select-link\"]")
    private WebElement flightsLocator;

    @FindBy(xpath = "//div[@class=\"uitk-price-lockup align-start\"]//span[@class=\"uitk-lockup-price\"]")
    private WebElement priceLabelInFlight;

    @FindBy(xpath = "//span[@class=\"uitk-text uitk-type-300 uitk-layout-flex-item uitk-text-emphasis-theme\"]")
    private WebElement timeLabelInFlight;

    @FindBy(css = ".uitk-heading-4")
    private WebElement departureDestinationInformation;

    @FindBy(xpath = "//div[@data-test-id=\"flight-operated\"]")
    private WebElement flightAirLineInformation;

    @FindBy(xpath = "//option[text()=\"Duration (Shortest)\"]")
    private WebElement shortestDurationButton;

    private By flightsList = By.xpath("//ul[@data-test-id=\"listings\"]");

    private By flightsListLocator = By.xpath("//li[@data-test-id=\"offer-listing\"]");

    private By closeButtonLocator = By.xpath("//div[@data-test-id=\"listing-details-and-fares\"]//button");

    private By priceFlightLocator = By.xpath("//div[@class=\"uitk-price-lockup align-start\"]//span[@class=\"uitk-lockup-price\"]");

    //*[@id="app-layer-base"]/div[3]/div[3]/div/section/main/div[6]/section/div[2]/div/div[2]/div[1]/span


    public SearchFlightScreen(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



    public boolean isComboBoxDisplayed(){
        waitWebElementToBeLocated(driver, By.id("listings-sort"), 60);
        //WebDriverWait wait = new WebDriverWait(driver, 60);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("listings-sort")));
        //WAIT IN BASE METHOD
        return  comboBoxDropdown.isDisplayed();
    }

    public boolean checkPriceLabelDisplayed(){
        boolean isPriceDisplayed = false;
        waitWebElementToBeLocated(driver, flightsList, 120);
        //WebDriverWait wait = new WebDriverWait(driver,120 );
        //wait.until(ExpectedConditions.presenceOfElementLocated(flightsList));
        List<WebElement> listOfFlights = flightsInList.findElements(flightsListLocator);
        System.out.println(listOfFlights.size());
        for (WebElement flightElement: listOfFlights) {
            waitWebElementToBeClickable(driver, flightsLocator, 10);
            //wait.until(ExpectedConditions.elementToBeClickable(flightsLocator));
            flightElement.click();
            waitWebElementVisibility(driver, priceLabelInFlight, 10);
            //wait.until(ExpectedConditions.visibilityOf(priceLabelInFlight));
            isPriceDisplayed = priceLabelInFlight.isDisplayed();
            waitWebElementToBeClickable(driver, closeIcon, 10);
            //wait.until(ExpectedConditions.elementToBeClickable(closeButtonLocator));
            closeIcon.click();
        }
        return isPriceDisplayed;
        //ADD CONDITION TO FALSE IF ANY OF THE ALAMENT IS FALSE
    }


    public boolean checkTimeFlightDisplayed(){
        boolean isTimeDisplayed = false;
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.presenceOfElementLocated(flightsList));
        List<WebElement> listOfFlights = flightsInList.findElements(flightsListLocator);
        System.out.println(listOfFlights.size());
        for (WebElement flightElement: listOfFlights) {
            wait.until(ExpectedConditions.elementToBeClickable(flightsLocator));
            flightElement.click();
            wait.until(ExpectedConditions.visibilityOf(timeLabelInFlight));
            isTimeDisplayed = timeLabelInFlight.isDisplayed();
            wait.until(ExpectedConditions.elementToBeClickable(closeButtonLocator));
            closeIcon.click();
        }
        return isTimeDisplayed;
        //ADD CONDITION TO FALSE IF ANY OF THE ELEMENT IS FALSE
    }

    public String checkDepartureAndDestination(){
        String departureDestinationLabel = "";
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.presenceOfElementLocated(flightsList));
        List<WebElement> listOfFlights = flightsInList.findElements(flightsListLocator);
        System.out.println(listOfFlights.size());
        for (WebElement flightElement: listOfFlights) {
            wait.until(ExpectedConditions.elementToBeClickable(flightsLocator));
            flightElement.click();
            wait.until(ExpectedConditions.visibilityOf(departureDestinationInformation));
            departureDestinationLabel = departureDestinationInformation.getText();
            wait.until(ExpectedConditions.elementToBeClickable(closeButtonLocator));
            closeIcon.click();
        }
        return departureDestinationLabel;
        //ADD CONDITION TO FALSE IF ANY OF THE ELEMENT IS FALSE
    }

    public boolean checkFlightAirLinetDisplayed(){
        boolean isFlightAirLineDisplayed = false;
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.presenceOfElementLocated(flightsList));
        List<WebElement> listOfFlights = flightsInList.findElements(flightsListLocator);
        System.out.println(listOfFlights.size());
        for (WebElement flightElement: listOfFlights) {
            wait.until(ExpectedConditions.elementToBeClickable(flightsLocator));
            flightElement.click();
            wait.until(ExpectedConditions.visibilityOf(flightAirLineInformation));
            isFlightAirLineDisplayed = flightAirLineInformation.isDisplayed();
            wait.until(ExpectedConditions.elementToBeClickable(closeButtonLocator));
            closeIcon.click();
        }
        return isFlightAirLineDisplayed;
        //ADD CONDITION TO FALSE IF ANY OF THE ELEMENT IS FALSE
    }

    public Select findDropDownElement(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(comboBoxDropdown));
        return new Select(comboBoxDropdown);
    }

    public void selectFromDropDown(String option){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("listings-sort")));
        findDropDownElement().selectByVisibleText(option);
    }

    public List<WebElement> getFlightsList() throws InterruptedException {
        timeOfFlightsList = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(flightsListLocator));
        Thread.sleep(5000);
        listOfFlights = flightsInList.findElements(flightsListLocator);
        System.out.println(listOfFlights.size());
        return listOfFlights;
    }

    public ArrayList<Integer> getPriceFlightsList(List<WebElement> flightsList){
        String flightTime = "";
        int hour;
        int minutes;
        int totalFlightTimeInMinutes;
        WebDriverWait wait = new WebDriverWait(driver,120 );
        for (WebElement flightElement: flightsList) {
            wait.until(ExpectedConditions.elementToBeClickable(flightsLocator));
            flightElement.click();
            wait.until(ExpectedConditions.visibilityOf(timeLabelInFlight));
            flightTime = timeLabelInFlight.getText();
            hour = Integer.parseInt(flightTime.substring(0,1));
            if (flightTime.substring(4,5).equals("m")){
                minutes = Integer.parseInt("0" + flightTime.substring(3,4));
            }else{
                minutes = Integer.parseInt(flightTime.substring(3,5));
            }
            wait.until(ExpectedConditions.elementToBeClickable(closeButtonLocator));
            closeIcon.click();
            totalFlightTimeInMinutes = (hour * 60) + minutes;
            timeOfFlightsList.add(totalFlightTimeInMinutes);
        }
        return timeOfFlightsList;
    }

    public ArrayList<Integer> getPriceFlightsListSorted(ArrayList<Integer> flightsPrice){
        Collections.sort(flightsPrice);
        return flightsPrice;
    }

    public Integer getFirstPriceFlightSorted(ArrayList<Integer> flightsPrice){
        return flightsPrice.get(0);
    }

    public DepartureFlightsPage clickOnFirstDepartureFlight(List<WebElement> firstFlightOption, int index){
        firstFlightOption.get(index).click();
        return new DepartureFlightsPage(driver);
    }

    public void click(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(comboBoxDropdown));
        comboBoxDropdown.click();
    }

 }
