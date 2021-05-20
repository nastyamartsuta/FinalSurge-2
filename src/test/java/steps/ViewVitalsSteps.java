package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        dailyVitalsPage.showLastMonthVitals();
        return this;
    }

    @Step
    public void checkLastMonthVitalsIsView() {
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