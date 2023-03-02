package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrames {

    private WebDriver driver;
    private By topFrame = By.name("frame-top");
    private By leftFrame = By.name("frame-left");
    private By leftFrameText = By.xpath("/html/body");
    private By bottomFrame = By.name("frame-bottom");
    private By bottomFrameText = By.xpath("/html/body");

    public NestedFrames(WebDriver driver){
        this.driver = driver;
    }

    private void switchToFrameTop(){
        WebElement webElement = driver.findElement(topFrame);
        driver.switchTo().frame(webElement);
    }

    private void switchToLefFrame(){
        switchToFrameTop();
        WebElement leftText = driver.findElement(leftFrame);
        driver.switchTo().frame(leftText);
    }

    public String getLeftFrameText(){
        switchToLefFrame();
        return driver.findElement(leftFrameText).getText();
    }

    public void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

    private void switchToFrameButton(){
        WebElement bottomFrameSection = driver.findElement(bottomFrame);
        driver.switchTo().frame(bottomFrameSection);
    }

    public String getBottomText(){
        switchToFrameButton();
        return driver.findElement(bottomFrameText).getText();
    }
}
