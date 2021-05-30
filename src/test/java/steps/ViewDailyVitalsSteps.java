package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DailyVitalsPage;

public class ViewDailyVitalsSteps extends AbstractStep {

    DailyVitalsPage dailyVitalsPage = new DailyVitalsPage(driver);

    public ViewDailyVitalsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open view page")
    public ViewDailyVitalsSteps openViewPage() {
        dailyVitalsPage.openPage();
        validateComponentIsLoaded(dailyVitalsPage);
        return this;
    }

    @Step("View last month daily vitals")
    public ViewDailyVitalsSteps viewLastMonthDailyVitals() {
        dailyVitalsPage.showLastMonthVitals();
        return this;
    }

    @Step("Checking Last Month Daily Vitals was viewed")
    public void checkingLastMonthDailyVitalsWasViewed() {
        Assert.assertEquals(
                dailyVitalsPage.actualDates().get(0).getText(),
                dailyVitalsPage.expectedDates().get(0),
                "Dates don't match");
        Assert.assertEquals(
                dailyVitalsPage.actualDates().get(1).getText(),
                dailyVitalsPage.expectedDates().get(1),
                "Dates don't match");
    }
}