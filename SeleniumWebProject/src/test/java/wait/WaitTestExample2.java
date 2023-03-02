package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTestExample2 extends BaseTests {

    @Test
    public void testWaitUntilHidden(){
        var example2Page = homePage.clickDynamicLoading().clickExample2();
        example2Page.clickStartButton();
        assertEquals(example2Page.getTextElement(), "Hello World!", "text not found");
    }
}
