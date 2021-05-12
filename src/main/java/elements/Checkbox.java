package elements;

import components.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Checkbox extends AbstractComponent {

    private static final String CHECKBOX_PATTERN = "//input[@id='%s']";
    private final String label;

    public Checkbox(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(locator()).isDisplayed();
    }

    private By locator() {
        return By.xpath(String.format(CHECKBOX_PATTERN, label));
    }

    public void selectCheckbox() {
        log.info("Select checkbox {} ", label);
        driver.findElement(locator()).click();
    }
}
