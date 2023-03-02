package TrainingTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class FirstMethod {

    @BeforeSuite
    public void firstMethod(){
        System.out.println("First suite");
    }

    @AfterSuite
    public void LasttMethod(){
        System.out.println("Last suite");
    }

}
