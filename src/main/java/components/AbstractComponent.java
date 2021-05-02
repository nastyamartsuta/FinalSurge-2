package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    protected WebDriver driver;
    protected WebDriverWait explicitlyWait;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, 10);
    }

    public void setExplicitlyWaitTimeout(int timeOutInSeconds) {
        this.explicitlyWait = new WebDriverWait(driver, timeOutInSeconds);
    }

    abstract public boolean isComponentDisplayed();
}