package pages;

import driver.DriverManagerFactory;
import elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebUtils;

public class RussianPage extends BaseForm{
    private final static Element uniq = new Element(By.xpath("//label[contains(text(),'Select Voice.')]"), "");

    private final Element convertButton = new Element(By.xpath("//button[contains(text(),'Convert')]"), "");
    private final Element clearButton = new Element(By.xpath("//button[contains(text(),'Clear Text')]"), "");
    private final Element textBox = new Element(By.className("text-box"), "");
    private final Element speedDropdown = new Element(By.className("rate"), "");
    private final String speedOption = "//section[@id='texttospeechmp3']//option[text()='%s']";


    public RussianPage() {
        super(uniq, "Russian");
    }


    public void clickConvertButton(){
        convertButton.click();
    }

    public void clickClearTextButton(){
        clearButton.click();
    }

    public void clickSpeedDropdown() {
        DriverManagerFactory.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(
                DriverManagerFactory.getInstance().findElement(speedDropdown.getLocator())));
        WebUtils.scrollIntoElement(speedDropdown.getElement());
        speedDropdown.click();
    }

    public void enterText(String text){
        textBox.sendKeys(text);
    }

    public void setSpeed(String speed){
        clickSpeedDropdown();
        String xPath = String.format(speedOption, speed);
        WebUtils.shortWait();
        DriverManagerFactory.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        Element option = new Element(By.xpath(xPath), "");
        option.click();
    }
}
