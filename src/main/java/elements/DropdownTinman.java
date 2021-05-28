package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DropdownTinman extends AbstractDropdown{

    private static final String DROPDOWN_PATTERN = "//option[contains(.,'%s')]/ancestor::div[@class='span6']//select[@name='distance']";

    public DropdownTinman(WebDriver driver, String label) {
        super(driver, label, DROPDOWN_PATTERN);
    }

    public void select(String optionValue) {
        log.info("Select option {} in Dropdown", optionValue);
        Select dropdown = new Select(element);
        dropdown.selectByValue(optionValue);
    }
}
