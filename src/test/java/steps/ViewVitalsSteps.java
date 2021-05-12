package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DailyVitalsPage;

public class ViewVitalsSteps extends AbstractStep {

    DailyVitalsPage dailyVitalsPage = new DailyVitalsPage(driver);

    public ViewVitalsSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public ViewVitalsSteps openViewPage() {
        dailyVitalsPage.openPage();
        validateComponentIsLoaded(dailyVitalsPage);
        return this;
    }

    @Step
    public ViewVitalsSteps viewLastMonthVitals() {
        return this;
    }
}