package elements;

import components.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class Autocomplete extends AbstractComponent {

    private static final String AUTOCOMPLETE_PATTERN = "%s";
    private static final String ELEMENTS_LINK = "//ul/li[contains(.,'12:45 AM')]";
    private final String label;

    public Autocomplete(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(locator()).isDisplayed();
    }

    private By locator() {
        return By.id(String.format(AUTOCOMPLETE_PATTERN, label));
    }

    public void enterAutocomplete(String text) {
        log.info("Autocomplete {} ", AUTOCOMPLETE_PATTERN);
        WebElement element = driver.findElement(locator());
        element.sendKeys(text);
        clickLinkElement();
    }

    public void clickLinkElement() {
        WebElement linkElement = driver.findElement(By.xpath(String.format(ELEMENTS_LINK, label)));
        linkElement.click();
    }
}