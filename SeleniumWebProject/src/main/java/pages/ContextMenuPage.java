package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private Actions actions;
    private By hotDSpotField = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void rightClickonElement(){
        WebElement webElement = driver.findElement(hotDSpotField);
        actions = new Actions(driver);
        actions.contextClick(webElement).perform();
    }

    public void alertAccept(){
        driver.switchTo().alert().accept();
    }

    public String getText(){
        return driver.switchTo().alert().getText();
    }
}
