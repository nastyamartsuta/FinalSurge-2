package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;

public class AbstractStep {
    WebDriver driver;

    public AbstractStep(WebDriver driver) {
        this.driver = driver;
    }

    protected void validateComponentIsLoaded(BasePage page) {
        //TODO Base Page
        Assert.assertTrue(page.isPageLoaded(), page.getClass().getSimpleName().concat(" was not opened: "));
    }
}
