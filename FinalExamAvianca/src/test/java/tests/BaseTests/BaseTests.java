package tests.BaseTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class BaseTests {

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
        ChromeOptions chrome_Profile = new ChromeOptions();
        chrome_Profile.addArguments("--disable-notifications");
        chrome_Profile.addArguments("--disable-save-password");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chrome_Profile);

        driver.get("https://www.avianca.com/");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @Test
    public void inputFlightConditions(){
        homePage.clickOnDepartureInputField();
        homePage.sendInputText("Bogota", Keys.ENTER, Keys.DOWN);
        homePage.clickOnDestinationInputField();
        homePage.sendInputDestinationText("Los Angeles", Keys.ENTER, Keys.DOWN);
        homePage.selectDatesDeparture();
        homePage.selectReturnDates();
        homePage.clickToIncrementTravelerButton();
        homePage.clickOnSearchButton();
    }

    @AfterSuite
    public void tearDown(){
        //driver.quit();
    }
}
