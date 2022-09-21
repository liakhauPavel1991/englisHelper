package pages;

import driver.DriverManagerFactory;
import elements.BaseElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.time.Duration;

public abstract class BaseForm {
    private BaseElement element;
    private String name;

    public BaseForm(BaseElement element, String name) {
        this.element = element;
        this.name = name;
    }

    public boolean isDisplayed() {
        Log.info(name + " is displayed");
        return element.isDisplayed();
    }
    public void waitForOpen() {
        Log.info("Wait for open " + name);
        WebDriverWait wait = new WebDriverWait(DriverManagerFactory.getInstance(),
                Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(element.getLocator()));
    }
    public static String getWindowHandle(){
        return DriverManagerFactory.getInstance().getWindowHandle();
    }
}

