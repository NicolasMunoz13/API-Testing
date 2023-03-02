package TrainingTest;

import okhttp3.Route;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class AnnotationTest {

    @Parameters({"StringA", "StringB"})
    @Test
    public void testConcat(String a, String b){
        String resutlado = a +b;
        assertEquals(resutlado, "I love test automation", "Incorrect test");
    }

    /*@BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforetest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @BeforeMethod
    public void login(){
        System.out.println("Login to the app");
    }

    @AfterMethod
    public void logout(){
        System.out.println("Logout the app");
    }

    @Test(groups = {"grupo1"})
    public void testConcact(){
        System.out.println("Test 1");
    }

    @Test(groups = {"grupo2", "grupo3"})
    public void testCount(){
        System.out.println("Test 2");
    }

    @Test(groups = {"grupo3"})
    public void testConcact2(){
        System.out.println("Test 3");
    }

    @Test(groups = {"grupo1"})
    public void testCount2(){
        System.out.println("Test 4");
    }*/
}
