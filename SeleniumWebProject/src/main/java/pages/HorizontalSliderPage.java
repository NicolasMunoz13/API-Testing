package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By keysArorws = By.tagName("input");
    private By resultText = By.id("range");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputRightArrow(String keyArrow){
       driver.findElement(keysArorws).sendKeys(keyArrow);
    }

    public String getResult(){
        return driver.findElement(resultText).getText();
    }


}
