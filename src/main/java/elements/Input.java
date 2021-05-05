package elements;

import components.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input extends AbstractComponent {

    private static final String INPUT_PATTERN = "%s";
    private String label;


    public Input(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(locator()).isDisplayed();
    }

    private By locator() {
        return By.id(String.format(INPUT_PATTERN, label));
    }

    public void enterInput(String text) {
        log.info("Send text to input {} ", label);
        driver.findElement(locator()).sendKeys(text);
    }

    public void clear() {
        driver.findElement(locator()).clear();
    }

}