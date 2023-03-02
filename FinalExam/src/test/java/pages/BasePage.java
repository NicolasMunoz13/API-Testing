package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;

    // time in seconds for waits methods.
    public final int MIN_WAIT_SECONDS = 1;
    public final int SHORT_WAIT_SECONDS = 5;
    public final int NORMAL_WAIT_SECONDS = 15;
    public final int MEDIUM_WAIT_SECONDS = 40;
    public final int LARGE_WAIT_SECONDS = 60;
    private static final int SECONDS_CONVERSION = 1000;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitWebElementVisibility(WebDriver driver, WebElement element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitWebElementToBeClickable(WebDriver driver, WebElement element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitWebElementToBeLocated(WebDriver driver, By element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }


    public void waitInSeconds(int seconds){
        try{
            Thread.sleep(seconds * SECONDS_CONVERSION);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }




}
