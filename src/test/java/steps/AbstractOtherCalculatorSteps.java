package steps;

import org.openqa.selenium.WebDriver;
import pages.OtherCalculatorPage;

public abstract class AbstractOtherCalculatorSteps extends AbstractStep {

    OtherCalculatorPage otherCalculatorPage = new OtherCalculatorPage(driver);

    public AbstractOtherCalculatorSteps(WebDriver driver) {
        super(driver);
    }

    public void openOtherCalculatorPage() {
        otherCalculatorPage.openPage();
        otherCalculatorPage = new OtherCalculatorPage(driver);
        validateComponentIsLoaded(otherCalculatorPage);
    }
}
