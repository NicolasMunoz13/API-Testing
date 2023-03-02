package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeparturePage extends BasePage{

    private WebDriver driver;

    @FindBy(xpath = "//button[@data-test-id=\"goto-checkout-button\"]")
    private WebElement checkoutButton;

    public DeparturePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setCheckOut(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test-id=\"goto-checkout-button\"]")));
        checkoutButton.click();
    }


}
