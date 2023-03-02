package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//it will apply to all elements
        driver.get("https://the-internet.herokuapp.com/");
        goHome();

        homePage = new HomePage(driver);

        //FIDNING WEB ELEMENTS

        /*List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        inputsLink.click();*/

        //Exercise, got to site and findElement, click on "Shifting Content"
        // and click on the first example and print the menu elements

        /*WebElement inputLink = driver.findElement(By.linkText("Shifting Content"));
        inputLink.click();

        WebElement menuLink = driver.findElement(By.linkText("Example 1: Menu Element"));
        menuLink.click();

        List<WebElement> linkElement = driver.findElements(By.tagName("li"));
        System.out.println(linkElement.size());*/


        //ELEMENT INTERACTIONS
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

    @AfterMethod
    public void takeScreenShotForRecordFailure(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenShot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenShot, new File("resources/ScreenShots*/" + result.getName() +".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
