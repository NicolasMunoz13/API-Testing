package TrainingTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMethod {

    @Test
    public void mainTest(){
        System.out.println("Test text");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Excuted before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Executed after test");
    }
}
