package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class DropDownListTests extends BaseTests {

    @Test
    public void DropDownAttributeTo(){
        homePage.clickDropDownAttribute().changeDropDownAttribute();
    }
}
