package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwgEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.xpath("//button[@title=\"Increase indent\"]");

    public WysiwgEditorPage(WebDriver driver){
        this.driver = driver;
    }

    private void swicthToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    public void switchToTheMainArea(){
        driver.switchTo().parentFrame();
    }

    public void decreaseIndentation(){
        driver.findElement(decreaseIndentButton).click();
    }

    public String getTextFromEditor(){
        swicthToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToTheMainArea();
        return text;
    }

    public void clearTextArea(){
        swicthToEditArea();
        driver.findElement(textArea).clear();
        switchToTheMainArea();
    }

    public void setTextArea(String text){
        swicthToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToTheMainArea();
    }

}
