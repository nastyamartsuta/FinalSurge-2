package elements;

import components.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Textarea extends AbstractComponent {

    private static final String TEXTAREA_PATTERN = "//label[contains(.,'%s')]/ancestor::div/textarea";
    private String label;

    public Textarea(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(locator()).isDisplayed();
    }

    private By locator() {
        return By.xpath(String.format(TEXTAREA_PATTERN, label));
    }

    public void enterTextarea(String text) {
        log.info("Send text to textarea {} ", label);
        driver.findElement(locator()).sendKeys(text);
    }
}
