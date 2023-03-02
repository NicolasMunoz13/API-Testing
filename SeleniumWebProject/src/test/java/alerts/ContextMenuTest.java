package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTests {

    @Test
    public void rightClickContext(){
        var contextPage = homePage.clickMenuContext();
        contextPage.rightClickonElement();
        String text = contextPage.getText();
        contextPage.alertAccept();
        assertEquals(text, "You selected a context menu", "text not selected");
    }
}
