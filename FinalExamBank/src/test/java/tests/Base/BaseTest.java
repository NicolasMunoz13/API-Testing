package tests.Base;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ResultPage;

import java.time.LocalDate;
import java.time.Period;


public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @Parameters({"browser"})
    @BeforeSuite
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get("https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/simulador-credito-libre-inversion/");
        homePage = new HomePage(driver);
    }

    @Parameters({"amount", "months", "dropDownOption", "yearDate", "monthDate", "testBirthDate", "browser"})
    @BeforeClass
    public void verifyLoanTest(String amount, String months, String dropDownOption, String yearDate, String monthDate, String testBirthDate, String browser) {
        var formPage = homePage.fillOutForm();
        ResultPage resultPage = new ResultPage(driver);
        try {
            if (Integer.parseInt(amount) > 1000000){
                formPage.setLoanAmount(amount);
                if (Integer.parseInt(months) > 6){
                    formPage.setMonthsInterval(Keys.BACK_SPACE, months);
                    formPage.selectFromDropDown(dropDownOption);
                    String parseDateFormat = testBirthDate.replace("/", "-");
                    LocalDate dob = LocalDate.parse(parseDateFormat);
                    LocalDate curDate = LocalDate.now();
                    int years = Period.between(dob, curDate).getYears();
                    if (years > 18 && years < 70){
                        formPage.setBirthDate(yearDate, monthDate, browser);
                        formPage.checkUnemploymentInsurance();
                        formPage.clickOnCalculate();
                    }else {
                        ((JavascriptExecutor)driver).executeScript("alert('Age should be greater than 18 and less than 70')");
                        System.out.println("Age should be greater than 18 and less than 70, was found " + years + " years");
                    }
                }else{
                    ((JavascriptExecutor)driver).executeScript("alert('Moths should be greater than 6')");
                    System.out.println("Moths should be greater than 6 months" +
                            "\n" + "Check method (FormPage.java:63)");
                }
            }else{
                ((JavascriptExecutor)driver).executeScript("alert('Amount should be greater than 1.000.000 COP')");
                System.out.println("Amount should be greater than 1.000.000 COP");
            }
        }catch (Exception e){
            System.out.println("Add the requested data in each field");
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
