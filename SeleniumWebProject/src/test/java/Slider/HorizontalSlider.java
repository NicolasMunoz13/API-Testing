package Slider;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class HorizontalSlider extends BaseTests {

    List<CharSequence> charList= new ArrayList<>();


    @Test
    public void testArrows(){
        for (int i = 0; i < 8; i++) {
            charList.add(Keys.ARROW_RIGHT);
        }
        var sliderPage = homePage.clickSlider();
        sliderPage.inputRightArrow(Keys.chord(charList));
        assertEquals(sliderPage.getResult(), "4", "Incorrect keys");
    }


}
