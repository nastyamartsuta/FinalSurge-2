package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DropdownSelectByVisibleText extends AbstractDropdown {

    private static final String DROPDOWN_PATTERN = "//select[@id='%s']";

    public DropdownSelectByVisibleText(WebDriver driver, String label) {
        super(driver, label, DROPDOWN_PATTERN);
    }

    public void select(String optionText) {
        log.info("Select option {} in Dropdown", optionText);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(optionText);
    }
}