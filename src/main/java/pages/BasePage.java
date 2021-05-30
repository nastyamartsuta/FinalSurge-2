package pages;

import elements.AbstractElements;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;



@Log4j2
public abstract class BasePage extends AbstractElements {

    public static final String DAY_PATTERN = "30";
    public static final String MONTH_PATTERN = "5";
    public static final String YEAR_PATTERN = "2021";

    public BasePage(WebDriver driver) {
        super(driver);
    }

    abstract public void waitPageLoaded();

    abstract public void openPage();

    public boolean isComponentDisplayed() {
        try {
            waitPageLoaded();
        } catch (TimeoutException ex) {
            log.info("The page was not opened");
            return false;
        }
        return true;
    }

    public boolean isPageLoaded() {
        return isComponentDisplayed();
    }
}
