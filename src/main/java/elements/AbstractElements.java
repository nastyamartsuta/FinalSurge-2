package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractElements {

    protected WebDriver driver;
    protected WebDriverWait explicitlyWait;

    public AbstractElements(WebDriver driver) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, 10);
    }

    public void setExplicitlyWaitTimeout(int timeOutInSeconds) {
        this.explicitlyWait = new WebDriverWait(driver, timeOutInSeconds);
    }

    abstract public boolean isComponentDisplayed();
}