package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownListAttribute {

    private WebDriver driver;
    private By dropDownList = By.id("dropdown");

    public DropDownListAttribute(WebDriver driver) {
        this.driver = driver;
    }

    public void changeDropDownAttribute() {
        WebElement dropDown = driver.findElement(dropDownList);
        String script = "document.querySelector(\"#dropdown\").setAttribute('multiple', '')";
        ((JavascriptExecutor)driver).executeScript(script, dropDown);
    }
}
