package steps;

import driver.DriverManagerFactory;
import pages.EnglishPage;
import pages.RussianPage;
import pages.SpeechPage;
import utils.WebUtils;

public class SpeechSteps {

    public static void openChrome(){
        DriverManagerFactory.getInstance().navigate().to("https://texttospeechrobot.com/");
    }

    public static void minimizeChrome(){
        DriverManagerFactory.getInstance().manage().window().minimize();
    }

    public static void setRussianSpeed(String speed){
        SpeechPage speechPage = new SpeechPage();
        RussianPage russianPage = speechPage.clickRussianTab();
        russianPage.setSpeed(speed);
    }

    public static void enterRussian(String text){
        System.out.println(text);
        SpeechPage speechPage = new SpeechPage();
        RussianPage russianPage = speechPage.clickRussianTab();
        russianPage.enterText(text);
        WebUtils.shortWait();
        russianPage.clickConvertButton();
        WebUtils.shortWait();
        russianPage.clickClearTextButton();
    }

    public static void enterEnglish(String text){
        System.out.println(text);
        SpeechPage speechPage = new SpeechPage();
        EnglishPage englishPage = speechPage.clickEnglishTab();
        englishPage.enterText(text);
        WebUtils.shortWait();
        englishPage.clickConvertButton();
        WebUtils.shortWait();
        englishPage.clickClearTextButton();
    }



}
