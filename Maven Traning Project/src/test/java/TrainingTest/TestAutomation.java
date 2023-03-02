package TrainingTest;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;



public class TestAutomation extends ClassesMethods {

    @Test
    public void testConat(){
        String text1 = "I love ";
        String text2 = "Test Automation";
        String resultado = text1 + text2;
        assertEquals(resultado, "I love Test Automation", "Incorrect concat");
        System.out.println("I love");
    }

    @Test
    public void testConat1(){
        String text1 = "I love ";
        String text2 = "Java";
        String resultado = text1 + text2;
        assertEquals(resultado, "I love Java", "Incorrect concat1");
        System.out.println("Java");
    }

    @Test
    public void testConat2(){
        String text1 = "I love ";
        String text2 = "Porn";
        String resultado = text1 + text2;
        assertEquals(resultado, "I love Porn", "Incorrect concat2");
        System.out.println("2");
    }
}
