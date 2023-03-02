package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable(){
        homePage.clickLargeDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFithParagapsh(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
