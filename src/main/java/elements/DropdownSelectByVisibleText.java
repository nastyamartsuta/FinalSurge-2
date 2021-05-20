package elements;

import components.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DropdownSelectByVisibleText extends AbstractComponent {

    private static final String DROPDOWN_PATTERN = "//select[@id='%s']";
    private final String label;

    public DropdownSelectByVisibleText(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(locator()).isDisplayed();
    }

    private By locator() {
        return By.xpath(String.format(DROPDOWN_PATTERN, label));
    }

    public void select(String optionText) {
        log.info("Select option {} in Dropdown {} ", optionText, label);
        WebElement dropdownElement = driver.findElement(locator());
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);
    }
}