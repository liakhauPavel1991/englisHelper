package pages;

import elements.Element;
import org.openqa.selenium.By;

public class EnglishPage extends BaseForm{
    private final static Element uniq = new Element(By.xpath("(//label[contains(text(),'Select Language.')])[2]"), "");

    private final Element convertButton = new Element(By.xpath("(//button[contains(text(),'Convert')])[2]"), "");
    private final Element clearButton = new Element(By.xpath("(//button[contains(text(),'Clear Text')])[2]"), "");

    private final Element textBox = new Element(By.xpath("(//textarea[@class='text-box'])[2]"), "");


    public EnglishPage() {
        super(uniq, "Russian");
    }

    public void clickConvertButton(){
        convertButton.click();
    }

    public void clickClearTextButton(){
        clearButton.click();
    }

    public void enterText(String text){
        textBox.sendKeys(text);
    }
}
