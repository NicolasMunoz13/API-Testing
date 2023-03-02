package util;

public class FailAssertions {

    public String setTestLoanAmountTextWhenFails(String currentValue, String testValue){
        return "Assert equals validation between the current " +
                "amount loan value sent to form " + (currentValue) + " and " +
                "test value " + (testValue) +
                "\n" + "Check file test.xml for parameter name 'amount'" +
                "\n" + "Check file ResultPage.java for method getRequestedAmount()";

    }

    public String setTestDropDownTextWhenFails(String currentValue, String testValue){
        return "Assert equals validation between the current " +
                "credit destination sent to form " + (currentValue) + " and " +
                "test value " + (testValue) +
                "\n" + "Check file test.xml for parameter name 'dropDownOption'" +
                "\n" + "Check file ResultPage.java for method getCreditDestination()";
    }

    public String setTestMonthsTextWhenFails(String currentValue, String testValue){
        return "Assert equals validation between the current " +
                "months sent to form " + (currentValue) + " and " +
                "test value " + (testValue) +
                "\n" + "Check file test.xml for parameter name 'months'" +
                "\n" + "Check file ResultPage.java for method getMonthsInterval()";
    }

    public String setTestAgeTextWhenFails(String currentValue, String testValue){
        return "Assert equals validation between the current " +
                "age in form " + (currentValue) + " years and " +
                "test value " + (testValue) + " years" +
                "\n" + "Check file test.xml for parameter name 'yearDate'" +
                "\n" + "Check file ResultPage.java for method getAge()";
    }
}
