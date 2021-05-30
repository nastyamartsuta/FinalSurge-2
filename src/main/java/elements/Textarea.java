package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorUtils;

@Log4j2
public class Textarea extends AbstractElements {

    private static final String TEXTAREA_PATTERN = "//label[contains(.,'%s')]/ancestor::div/textarea";
    private final String label;
    private final WebElement element;

    public Textarea(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.element = LocatorUtils.createByXpath(driver, TEXTAREA_PATTERN, label);
    }

    @Override
    public boolean isComponentDisplayed() {
        return element.isDisplayed();
    }

    public void enterTextarea(String text) {
        log.info("Send text to textarea {} ", label);
        element.sendKeys(text);
    }
}
