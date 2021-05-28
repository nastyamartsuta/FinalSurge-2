package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LocatorUtils;
import utils.StringUtils;

@Log4j2
public class Autocomplete extends AbstractElements {

    private static final String AUTOCOMPLETE_PATTERN = "%s";
    private static final String ELEMENTS_LINK = "//ul/li[contains(.,'12:45 AM')]";
    private final String label;
    private final WebElement element;

    public Autocomplete(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.element = LocatorUtils.createById(driver, AUTOCOMPLETE_PATTERN, label);
    }

    @Override
    public boolean isComponentDisplayed() {
        return element.isDisplayed();
    }

    public void enterAutocomplete(String text) {
        log.info("Autocomplete {} ", AUTOCOMPLETE_PATTERN);
        element.sendKeys(text);
        clickLinkElement();
    }

    public void clickLinkElement() {
        WebElement linkElement = LocatorUtils.createByXpath(driver, ELEMENTS_LINK, label);
        linkElement.click();
    }
}