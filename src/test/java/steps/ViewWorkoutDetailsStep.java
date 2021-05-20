package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ViewWorkoutPage;

public class ViewWorkoutDetailsStep extends AbstractCalendarPageSteps {

    public ViewWorkoutDetailsStep(WebDriver driver) {
        super(driver);
    }

    @Step
    public ViewWorkoutDetailsStep openWorkoutsDetailsPage() {
        viewWorkoutPage = new ViewWorkoutPage(driver);
        openCalendarPage();
        viewWorkoutPage.openPage();
        return this;
    }

    @Step
    public void checkingWorkoutsDetailsPageOpened() {
        validateComponentIsLoaded(viewWorkoutPage);
    }
}
