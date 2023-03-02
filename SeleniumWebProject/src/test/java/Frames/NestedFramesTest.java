package Frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NestedFramesTest extends BaseTests {

    @Test
    public void TestLeftFrames(){
        var framesPage = homePage.clickFramesPage();
        var nestedFrames = homePage.clickNestedFramesPages();
        String text = nestedFrames.getLeftFrameText();
        assertEquals(text, "LEFT", "Text not found");
    }

    @Test
    public void TestBottomFrames(){
        var framesPage = homePage.clickFramesPage();
        var nestedFrames = homePage.clickNestedFramesPages();
        String text = nestedFrames.getBottomText();
        assertEquals(text, "BOTTOM", "Text not found");
    }
}
