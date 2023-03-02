package TrainingTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClassesMethods {

    @Test
    public void classTest(){
        System.out.println("class 1st");
    }

    @Test
    public void classTest2(){
        System.out.println("class 2st");
    }

    @BeforeClass
    public void firstClass(){
        System.out.println("First class");
    }

    @AfterClass
    public void lastClass(){
        System.out.println("Last class");
    }

}
