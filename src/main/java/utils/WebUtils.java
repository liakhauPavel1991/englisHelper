package utils;

import com.google.common.base.Function;
import driver.DriverManagerFactory;
import elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Supplier;

import static io.appium.java_client.pagefactory.utils.WebDriverUnpackUtility.unpackWebDriverFromSearchContext;

public class WebUtils {
    public static void shortWait(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waiting(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitUntil(Supplier<Boolean> condition) {
        Function<WebDriver, Boolean> conditionToBeTrue = (WebDriver d) -> condition.get().equals(Boolean.TRUE);
        DriverManagerFactory.getWebDriverWait().until(conditionToBeTrue);
    }


    public static WebElement scrollIntoElement(WebElement e) {
        getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true)", e);
        return e;
    }

    private static JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) DriverManagerFactory.getInstance();
    }
}
