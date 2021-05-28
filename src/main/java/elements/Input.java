package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorUtils;

@Log4j2
public class Input extends AbstractElements {

    private static final String INPUT_PATTERN = "%s";
    private final String label;
    private final WebElement element;

    public Input(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.element = LocatorUtils.createById(driver, INPUT_PATTERN, label);
    }

    @Override
    public boolean isComponentDisplayed() {
        return element.isDisplayed();
    }

    public void enterInput(String text) {
        log.info("Send text to input {} ", label);
        element.sendKeys(text);
    }

    public void clear() {
        element.clear();
    }
}