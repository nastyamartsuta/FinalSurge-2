package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorUtils;

@Log4j2
public class DropdownEquipment extends AbstractDropdown {

    private static final String DROPDOWN_PATTERN = "//div[@id='%s']/a";
    private static final String DROPDOWN_ITEM_PATTERN = "//ul[@class='select2-results']//div[contains(.,'%s')]";

    public DropdownEquipment(WebDriver driver, String label) {
        super(driver, label, DROPDOWN_PATTERN);
    }

    @Override
    public void select(String optionValue) {
        log.info("Select option {} in Dropdown", optionValue);
        element.click();
        WebElement dropdownItem = LocatorUtils.createByXpath(driver, DROPDOWN_ITEM_PATTERN, optionValue);
        dropdownItem.click();
    }
}
