package Frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTest extends BaseTests {

    @Test
    public void testWysiwg(){
        var editorPage = homePage.clickwysiwgEditor();
        editorPage.clearTextArea();

        String text1 = "Hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndentation();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(), text1+text2, "Incorrect text");
    }

}
