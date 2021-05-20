package elements;

import components.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DropdownTinman extends AbstractComponent {

    private static final String DROPDOWN_PATTERN = "//div[@class='span6']/select";

    public DropdownTinman(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(locator()).isDisplayed();
    }

    private By locator() {
        return By.xpath(DROPDOWN_PATTERN);
    }

    public void select(String optionValue) {
        log.info("Select option {} in Dropdown", optionValue);
        WebElement dropdownElement = driver.findElement(locator());
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(optionValue);
    }
}
