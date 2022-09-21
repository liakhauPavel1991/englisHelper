package pages;

import elements.BaseElement;
import elements.Element;
import org.apache.hc.client5.http.classic.ExecRuntime;
import org.openqa.selenium.By;

public class SpeechPage extends BaseForm {
    private final static Element unique = new Element(By.id("speak_button"),"");
    private final Element playButton = new Element(By.id("speak_button"),"");
    private final Element karaokeTab = new Element(By.xpath("//label[contains(text(),'Karaoke Ver')]"),"");
    private final Element v3Tab = new Element(By.xpath("//label[@for='tab2']"),"");
    private final Element v4Tab = new Element(By.xpath("//label[@for='tab3']"),"");
    private final Element clearButton = new Element(By.id("clear_button"),"");
    private final Element replayButton = new Element(By.id("reset_button"),"");
    private final String languageOption = "//select[@id='select_language']/option[text()='%s']";

    public SpeechPage() {
        super(unique, "name");
    }

    public RussianPage clickRussianTab(){
        v3Tab.click();
        return new RussianPage();
    }

    public EnglishPage clickEnglishTab(){
        v4Tab.click();
        return new EnglishPage();
    }

    public void clickPlayButton(){
        playButton.click();
    }

    public void clickClearButton(){
        clearButton.click();
    }

    public void clickReplayButton(){
        replayButton.click();
    }




}
