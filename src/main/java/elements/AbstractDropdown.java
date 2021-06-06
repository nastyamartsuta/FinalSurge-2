package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorUtils;

@Log4j2
public abstract class AbstractDropdown extends AbstractElements {

    protected final WebElement element;

    public AbstractDropdown(WebDriver driver, String label, String dropdownPattern) {
        super(driver);
        log.info("Finding a dropdown");
        this.element = LocatorUtils.createByXpath(driver, dropdownPattern, label);
    }

    public boolean isComponentDisplayed() {
        return element.isDisplayed();
    }

    abstract public void select(String optionValue);
}


