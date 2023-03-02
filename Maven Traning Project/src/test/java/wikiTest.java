import ArticlePage.ArticlePage;
import HomePage.WikiHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class wikiTest extends BaseTest{

    @Test
    public void testWikiSearch(){
        WikiHomePage home = getWikiHomePage();
        ArticlePage articlePage = home.buscar("Java");
        Assert.assertEquals(articlePage.getPageTitle(), "Java");

    }
}
