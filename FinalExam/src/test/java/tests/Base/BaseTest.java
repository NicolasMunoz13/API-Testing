package tests.Base;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SearchFlightScreen;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;


    //@Parameters
    @BeforeSuite
    public void setUp(/*String browser*/){
        /*if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }*/

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.travelocity.com/");
        homePage = new HomePage(driver);
    }
    
    @BeforeTest
    public void inputFlightConditions(){
        homePage.clickOnFlightsButton();
        homePage.clickOnDepartureInputField();
        homePage.sendInputText("Las Vegas (LAS - All Airports)", Keys.ENTER);
        homePage.clickOnDestinationInputField();
        homePage.sendInputDestinationText("Los Angeles Intl. (LAX)", Keys.ENTER);
        homePage.pickOnTravelersFieldButton();
        homePage.clickToIncrementTravelerButton();
        homePage.selectDates();
    }

    @AfterSuite
    public void tearDown(){
        //driver.quit();
    }
}
