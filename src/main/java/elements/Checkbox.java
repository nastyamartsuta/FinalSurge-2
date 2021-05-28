package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorUtils;

@Log4j2
public class Checkbox extends AbstractElements {

    private static final String CHECKBOX_PATTERN = "//input[@id='%s']";
    private final WebElement element;

    public Checkbox(WebDriver driver, String label) {
        super(driver);
        this.element = LocatorUtils.createByXpath(driver, CHECKBOX_PATTERN, label);
    }

    @Override
    public boolean isComponentDisplayed() {
        return element.isDisplayed();
    }

    public void selectCheckbox() {
        log.info("Select checkbox");
        element.click();
    }
}
