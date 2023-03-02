package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver pDriver){
        this.driver = pDriver;
        PageFactory.initElements(pDriver, this);
    }
}
