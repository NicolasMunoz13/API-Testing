package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.Period;

public class ResultPage extends BasePage{

    private WebDriver driver;

    @FindBy(xpath = "//dl[@class=\"results-info gi one-half\"][1]/dd[3]")
    private WebElement requestedAmountText;

    @FindBy(xpath = "//dl[@class=\"results-info gi one-half\"][1]/dd[4]")
    private WebElement requestedCreditText;

    @FindBy(xpath = "//dl[@class=\"results-info gi one-half\"][1]/dd[5]")
    private WebElement monthsIntervalText;

    @FindBy(xpath = "//dl[@class=\"results-info gi one-half\"][1]/dd[6]")
    private WebElement ageText;

    @FindBy(name = "i_fecha_nacimiento_submit")
    private WebElement birthDate;

    private By ageResult = By.xpath("//dl[@class=\"results-info gi one-half\"][1]/dd[6]");

    public ResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getRequestedAmount(){
        waitWebElementVisibility(driver, requestedAmountText, 5);
        String amountRequested = requestedAmountText.getText();
        String amountWithOutLastDigits = amountRequested.substring(1, amountRequested.length()-3);
        String amountWithoutComas = amountWithOutLastDigits.replace(",", "");
        return amountWithoutComas;
    }

    public String getCreditDestination(){
        waitWebElementVisibility(driver, requestedCreditText, 5);
        return requestedCreditText.getText();
    }

    public String getMonthsInterval(){
        waitWebElementVisibility(driver, monthsIntervalText, 5);
        return monthsIntervalText.getText();
    }

    public String getAge(String text){
        String ageFound = "";
        try {
            waitWebElementToHaveText(driver, ageResult, text, 5);
            ageFound = ageText.getText();
        }catch (TimeoutException e){
            System.out.println("Age is expected to be " + text + " but was not found " + e);
        }
        return  ageFound;
    }

    public String getAgeDifference(){
        String birthDateText = birthDate.getAttribute("value");
        String parseDateFormat = birthDateText.replace("/", "-");
        LocalDate dob = LocalDate.parse(parseDateFormat);
        LocalDate curDate = LocalDate.now();
        String yearDifferenceText = "";
        int years  = 0;
        if ((dob != null) && (curDate != null)){
            years = Period.between(dob, curDate).getYears();
        }else {
            years = 0;
        }
        yearDifferenceText = String.valueOf(years);
        return yearDifferenceText;
    }

    public String getTestAgeDifference(String testBirthDate){
        String parseDateFormat = testBirthDate.replace("/", "-");
        LocalDate dob = LocalDate.parse(parseDateFormat);
        LocalDate curDate = LocalDate.now();
        String yearDifferenceText = "";
        int years  = 0;
        if ((dob != null) && (curDate != null)){
            years = Period.between(dob, curDate).getYears();
        }else {
            years = 0;
        }
        yearDifferenceText = String.valueOf(years);
        return yearDifferenceText;
    }

}
