package elements;

import driver.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.Log;

public abstract class BaseElement {

    protected static WebDriver driver = DriverManagerFactory.getInstance();
    private By locator;
    private String name;

    public BaseElement(By locator, String name){
        this.locator = locator;
        this.name = name;
    }
    public By getLocator (){
        return locator;
    }

    protected Dimension getSize(){
        return driver.findElement(locator).getSize();
    }

    protected int getWidth(){
        return getSize().getWidth();
    }

    public WebElement getElement(){
        return driver.findElement(locator);
    }

    public boolean isDisplayed(){
        Log.info(name + "is displayed");
        return driver.findElement(locator).isDisplayed();
    }

    public void click(){
        Log.info("Click on " + name);
        driver.findElement(locator).click();
    }

    public String getText(){
        Log.info("Get text from " + name);
        return driver.findElement(locator).getText();
    }

    public String getAttribute(String atrName){
        Log.info("Get attribute " + name);
        return driver.findElement(locator).getAttribute(atrName);
    }

    public void sendKeys(String text){
        Log.info("send text ");
        driver.findElement(locator).sendKeys(text);
    }

    public void moveCursor () {
        Log.info("Move cursor");
        Actions moveCursor  = new Actions(driver);
        WebElement element = getElement();
        Action action = moveCursor.moveToElement(element).build();
        action.perform();
    }
}

