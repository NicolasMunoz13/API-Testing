package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FormPage extends BasePage{

    private WebDriver driver;

    @FindBy(id = "i_monto_prestamo")
    private WebElement loanInputField;

    @FindBy(id = "i_plazo_meses")
    private WebElement monthsIntervalField;

    @FindBy(id = "i_fecha_nacimiento")
    private WebElement birthDateInputField;

    @FindBy(xpath = "//div[text()=\"18\"]")
    private WebElement dayDatePicker;

    private By day = By.xpath("//div[text()=\"18\"]");

    @FindBy(xpath = "//label[@for=\"radioSI\"]")
    private WebElement radioCheckYes;

    @FindBy(xpath = "//button[text()=\"Calcular\"]")
    private WebElement calculateButton;

    private By creditDropDownField = By.id("s_destinocredito");

    private By yearDatePicker = By.className("picker__select--year");

    private By monthDatePicker = By.className("picker__select--month");


    public FormPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setLoanAmount(String loanAmount){
        clickOnWebElement(loanInputField);
        loanInputField.sendKeys(loanAmount);
    }

    public void setMonthsInterval(Keys deleteKey, String monthsAmount){
        clickOnWebElement(monthsIntervalField);
        monthsIntervalField.sendKeys(deleteKey);
        monthsIntervalField.sendKeys(monthsAmount);
    }

    public void selectFromDropDown(String option){
        findDropDownElement(creditDropDownField).selectByVisibleText(option);
    }

    private Select findDropDownElement(By ByElement){
        return new Select(driver.findElement(ByElement));
    }

    public void setBirthDate(String yearDate, String monthDate, String browser) {
        clickOnWebElement(birthDateInputField);
        waitWebElementToBeLocated(driver, yearDatePicker, 5);
        findDropDownElement(yearDatePicker).selectByVisibleText(yearDate);
        waitWebElementToBeLocated(driver, monthDatePicker, 5);
        findDropDownElement(monthDatePicker).selectByVisibleText(monthDate);
        if(browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("edge")){
            clickOnWebElement(dayDatePicker);
            clickOnWebElement(dayDatePicker);
        }else if(browser.equalsIgnoreCase("firefox")){
            clickOnWebElement(dayDatePicker);
        }
    }

    public void checkUnemploymentInsurance(){
        clickOnWebElement(radioCheckYes);
    }

    public void clickOnCalculate(){
        clickOnWebElement(calculateButton);
    }

    public ResultPage getLoanInformationResults(){
        return new ResultPage(driver);
    }




}
