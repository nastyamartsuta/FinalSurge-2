package elements;

import components.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class DropdownEquipment extends AbstractComponent {

    private static final String OPEN_DROPDOWN_SHOES_PATTERN = "//div[@id='s2id_ShoeBrand']/a";
    private static final String SELECT_ELEMENT = "//ul[@class='select2-results']//div[contains(.,'%s')]";
    private final String label;

    public DropdownEquipment(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(locator()).isDisplayed();
    }

    private By locator() {
        return By.xpath(String.format(SELECT_ELEMENT, label));
    }

    public void select(){
        log.info("Select option in Dropdown");
        WebElement openDropdown = driver.findElement(By.xpath(OPEN_DROPDOWN_SHOES_PATTERN));
        openDropdown.click();

        WebElement selectElement = driver.findElement(locator());
        selectElement.click();
    }
}
