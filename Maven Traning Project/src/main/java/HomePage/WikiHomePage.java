package HomePage;

import ArticlePage.ArticlePage;
import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikiHomePage extends BasePage {

    private WebDriver driver;

    public WikiHomePage(WebDriver driver) {
        super(driver);
        driver.get("http://wikipedia.org");
    }

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='search-form']/fieldset/button")
    private WebElement searchButton;

    public ArticlePage buscar(String busqueda){
        searchInput.sendKeys(busqueda);
        getWait().until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return new ArticlePage(getDriver());
    }

}
