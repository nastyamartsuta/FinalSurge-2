package elements;

import components.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RadioButton extends AbstractComponent {

    private static final String RADIO_BUTTON_PATTERN = "//label[contains(.,'%s')]/input";
    private String label;

    public RadioButton(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(locator()).isDisplayed();
    }

    private By locator() {
        return By.xpath(String.format(RADIO_BUTTON_PATTERN, label));
    }

    public void selectRadioButton() {
        log.info("Select Radio Button {} ", label);
        driver.findElement(locator()).click();
    }

}
