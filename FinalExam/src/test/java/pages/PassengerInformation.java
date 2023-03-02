package pages;

import com.sun.jdi.PrimitiveValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassengerInformation extends BasePage{

    private WebDriver driver;

    private By test = By.xpath("//*[@id=\"summary-container\"]/article/div[1]/div[1]/h2");

    @FindBy(id = "firstname[0]")
    private WebElement firstNameInputField;

    @FindBy(id = "middlename[0]")
    private WebElement middleNameInputField;

    @FindBy(id = "lastname[0]")
    private WebElement lastNameInputField;

    @FindBy(id = "country_code[0]")
    private WebElement countryCodeDropDown;

    @FindBy(id="phone-number[0]")
    private WebElement phoneNumberInputField;

    @FindBy(id = "gender_male[0]")
    private WebElement maleGenderCheckBox;

    @FindBy(id = "gender_female[0]")
    private WebElement femaleGenderCheckBox;

    @FindBy(id = "date_of_birth_month0")
    private WebElement monthBirthday;

    @FindBy(id = "date_of_birth_day[0]")
    private WebElement dayBirthday;

    @FindBy(id = "date_of_birth_year[0]")
    private WebElement yearBirthday;

    @FindBy(id = "firstname[1]")
    private WebElement firstNameInputFieldSecondPassenger;

    @FindBy(id = "middlename[1]")
    private WebElement middleNameInputFieldSecondPassenger;

    @FindBy(id = "lastname[1]")
    private WebElement lastNameInputFieldSecondPassenger;

    @FindBy(id="phone-number[1]")
    private WebElement phoneNumberInputFieldSecondPassenger;

    @FindBy(id = "gender_male[1]")
    private WebElement maleGenderCheckBoxSecondPassenger;

    @FindBy(id = "gender_female[1]")
    private WebElement femaleGenderCheckBoxSecondPassenger;

    @FindBy(xpath = "//select[@data-tealeaf-name=\"date_of_birth_month[1]\"]")
    private WebElement monthBirthdaySecondPassenger;

    @FindBy(xpath = "//select[@data-tealeaf-name=\"date_of_birth_day[1]\"]")
    private WebElement dayBirthdaySecondPassenger;

    @FindBy(xpath = "//select[@data-tealeaf-name=\"date_of_birth_year[1]\"]")
    private WebElement yearBirthdaySecondPassenger;

    @FindBy(xpath = "//a[@href=\"#standaloneToggle0\"]")
    private WebElement priceSummaryFirstPassenger;

    @FindBy(xpath = "//a[@href=\"#standaloneToggle1\"]")
    private WebElement priceSummarySecondPassenger;

    @FindBy(id = "complete-booking")
    private WebElement completeBookingButton;

    @FindBy(id = "yes_insurance")
    private WebElement insuranceOption;

    @FindBy(xpath = "//a[text()=\"Debit/Credit Card\"]")
    private WebElement debitCreditCardLink;

    @FindBy(id = "creditCardInput")
    private WebElement debitCreditCardInputField;


    public PassengerInformation(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getTezt(){
        return  driver.findElement(test).getText();
    }

    public void setUserInformation(String firstName, String middleName, String lastName, String phoneNumber){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInputField));
        firstNameInputField.click();
        firstNameInputField.sendKeys(firstName);
        middleNameInputField.click();
        middleNameInputField.sendKeys(middleName);
        lastNameInputField.click();
        lastNameInputField.sendKeys(lastName);
        phoneNumberInputField.click();
        phoneNumberInputField.sendKeys(phoneNumber);
    }

    public Select findDropDownElement(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(countryCodeDropDown));
        return new Select(countryCodeDropDown);
    }

    public void selectFromDropDown(String option){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country_code[0]")));
        findDropDownElement().selectByVisibleText(option);
    }

    public void clickOnGenderCheckBox(String gender){
        if(gender.equals("Male")){
            maleGenderCheckBox.click();
        }else if(gender.equals("Female")){
            femaleGenderCheckBox.click();
        }
    }

    public Select findMonthDropDown(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(monthBirthday));
        return new Select(monthBirthday);
    }

    public Select findDayDropDown(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(dayBirthday));
        return new Select(dayBirthday);
    }

    public Select findYearDropDown(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(yearBirthday));
        return new Select(yearBirthday);
    }

    public void selectBirth(String monthOption, String dayOption, String yearOption){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date_of_birth_month0")));
        findMonthDropDown().selectByVisibleText(monthOption);
        findDayDropDown().selectByVisibleText(dayOption);
        findYearDropDown().selectByVisibleText(yearOption);
    }

    public void setUserInformationSecondOption(String firstName, String middleName, String lastName){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInputFieldSecondPassenger));
        firstNameInputFieldSecondPassenger.click();
        firstNameInputFieldSecondPassenger.sendKeys(firstName);
        middleNameInputFieldSecondPassenger.click();
        middleNameInputFieldSecondPassenger.sendKeys(middleName);
        lastNameInputFieldSecondPassenger.click();
        lastNameInputFieldSecondPassenger.sendKeys(lastName);
    }

    public void clickOnGenderCheckBoxSecondOption(String gender){
        if(gender.equals("Male")){
            maleGenderCheckBoxSecondPassenger.click();
        }else if(gender.equals("Female")){
            femaleGenderCheckBoxSecondPassenger.click();
        }
    }

    public Select findMonthDropDownSecondOption(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(monthBirthdaySecondPassenger));
        return new Select(monthBirthdaySecondPassenger);
    }

    public Select findDayDropDownSecondOption(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(dayBirthdaySecondPassenger));
        return new Select(dayBirthdaySecondPassenger);
    }

    public Select findYearDropDownSecondOption(){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.elementToBeClickable(yearBirthdaySecondPassenger));
        return new Select(yearBirthdaySecondPassenger);
    }

    public void selectBirthSecondOption(String monthSecondOption, String daySecondOption, String yearSecondOption){
        WebDriverWait wait = new WebDriverWait(driver,120 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date_of_birth_month0")));
        findMonthDropDownSecondOption().selectByVisibleText(monthSecondOption);
        findDayDropDownSecondOption().selectByVisibleText(daySecondOption);
        findYearDropDownSecondOption().selectByVisibleText(yearSecondOption);
    }

     public boolean isPassengerPriceSummaryDisplayed(){
        boolean priceSummary;
        if(priceSummaryFirstPassenger.isDisplayed() == true && priceSummarySecondPassenger.isDisplayed() == true){
            priceSummary = true;
        }else {
            priceSummary = false;
        }
        return  priceSummary;
     }

     public boolean isCompleteBookingButtonDisplayed(){
        return completeBookingButton.isDisplayed();
     }

     public boolean isInsuranceAvailable(){
        insuranceOption.click();
        return  insuranceOption.isEnabled();
     }

     public String getDebitCardText(){
        return debitCreditCardLink.getText();
     }

     public boolean setDebitCreditCardNumber(){
        return debitCreditCardInputField.isEnabled();
     }


}
