package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class Dropdown extends AbstractDropdown {

    private static final String DROPDOWN_PATTERN = "//select[@id='%s']";

    public Dropdown(WebDriver driver, String label) {
        super(driver, label, DROPDOWN_PATTERN);
    }

    @Override
    public void select(String optionValue) {
        log.info("Select option {} in Dropdown", optionValue);
        Select dropdown = new Select(element);
        dropdown.selectByValue(optionValue);
    }
}
