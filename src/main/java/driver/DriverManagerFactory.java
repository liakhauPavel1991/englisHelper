package driver;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.time.Duration;

public class DriverManagerFactory {
    private static WebDriver webDriver = null;
    private static WebDriverWait webDriverWaiter;
    private static String browserName = "CHROME";
    private static Duration DEFAULT_TIMEOUT_TO_WAIT = Duration.ofSeconds(15);

    public static WebDriver getInstance() {
        if (webDriver == null) {
            Log.info("Driver not found. Create driver");
            switch (browserName) {
                case "CHROME": {
                    Log.info("Create Chrome driver");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    Log.info("Set browser options");
                    webDriver = new ChromeDriver(chromeOptions);
                }
            }
        }
        return webDriver;
    }

    public static void quitDriver() {
        try {
            webDriver.quit();
        } catch (Exception e) {
            Log.warn("Couldn't quit one of the locally created drivers because: " + e);
        }
        webDriver = null;
    }

    public static WebDriverWait getWebDriverWait() {
        if (webDriverWaiter == null){
            webDriverWaiter = new WebDriverWait(getInstance(), DEFAULT_TIMEOUT_TO_WAIT);
        }
        webDriverWaiter.withTimeout(DEFAULT_TIMEOUT_TO_WAIT).ignoring(StaleElementReferenceException.class);
        return webDriverWaiter;
    }

}

