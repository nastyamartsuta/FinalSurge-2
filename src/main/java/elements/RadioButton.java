package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorUtils;

@Log4j2
public class RadioButton extends AbstractElements {

    private static final String RADIO_BUTTON_PATTERN = "//label[contains(.,'%s')]/input";
    private final String label;
    private final WebElement element;

    public RadioButton(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.element = LocatorUtils.createByXpath(driver, RADIO_BUTTON_PATTERN, label);
    }

    @Override
    public boolean isComponentDisplayed() {
        return element.isDisplayed();
    }

    public void selectRadioButton() {
        log.info("Select Radio Button {} ", label);
        element.click();
    }
}
