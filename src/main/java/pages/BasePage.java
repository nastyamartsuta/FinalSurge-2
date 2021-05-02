package pages;

import components.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;


@Log4j2
public abstract class BasePage extends AbstractComponent {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    abstract public void waitPageLoaded();

    abstract public void openPage();

    public boolean isComponentDisplayed() {
        try {
            waitPageLoaded();
        } catch (TimeoutException ex) {
            log.info("EXCEPTION HAS BEEN CAUGHT");
            return false;
        }
        return true;
    }

    public boolean isPageLoaded() {
        return isComponentDisplayed();
    }
}
