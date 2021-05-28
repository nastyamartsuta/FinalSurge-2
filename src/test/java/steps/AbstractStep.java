package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;

public abstract class AbstractStep {
    WebDriver driver;

    public AbstractStep(WebDriver driver) {
        this.driver = driver;
    }

    protected void validateComponentIsLoaded(BasePage page) {
        Assert.assertTrue(page.isPageLoaded(), page.getClass().getSimpleName().concat(" was not opened: "));
    }
}
