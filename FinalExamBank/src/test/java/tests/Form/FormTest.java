package tests.Form;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ResultPage;
import tests.Base.BaseTest;
import util.FailAssertions;

public class FormTest extends BaseTest {

    ResultPage resultPage;
    FailAssertions failAssertions = new FailAssertions();

    @Parameters({"amount", "amountResultTest"})
    @Test
    public void verifyRequestedAmount(String amount, String amountResultTest){
        resultPage = homePage.fillOutForm().getLoanInformationResults();
        Assert.assertEquals(resultPage.getRequestedAmount(), amountResultTest, failAssertions.setTestLoanAmountTextWhenFails(amount, amountResultTest));
    }

    @Parameters({"dropDownOption", "dropDownOptionResultTest"})
    @Test
    public void verifyCreditDestination(String dropDownOption, String dropDownOptionResultTest){
        resultPage = homePage.fillOutForm().getLoanInformationResults();
        Assert.assertEquals(resultPage.getCreditDestination(), dropDownOptionResultTest, failAssertions.setTestDropDownTextWhenFails(dropDownOption, dropDownOptionResultTest));
    }

    @Parameters({"months", "monthsResultTest"})
    @Test
    public void verifyMonthInterval(String months, String monthsResultTest){
        resultPage = homePage.fillOutForm().getLoanInformationResults();
        Assert.assertEquals(resultPage.getMonthsInterval(), monthsResultTest + " Meses", failAssertions.setTestMonthsTextWhenFails(months, monthsResultTest));
    }

    @Parameters({"testBirthDate"})
    @Test
    public void verifyAge(String yearDateTest){
        resultPage = homePage.fillOutForm().getLoanInformationResults();
        String realYearDifference = resultPage.getAgeDifference();
        String testYearDifference = resultPage.getTestAgeDifference(yearDateTest);
        Assert.assertEquals(resultPage.getAge( realYearDifference+ " Años"), testYearDifference + " Años", failAssertions.setTestAgeTextWhenFails(realYearDifference, testYearDifference));
    }

}
