package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ViewWorkoutPage;

import static pages.BasePage.*;
import static pages.CalendarPage.WORKOUTS;

public class ViewWorkoutDetailsStep extends AbstractCalendarPageSteps {

    public ViewWorkoutDetailsStep(WebDriver driver) {
        super(driver);
    }

    @Step
    public ViewWorkoutDetailsStep openWorkoutsDetailsPage() {
        viewWorkoutPage = new ViewWorkoutPage(driver);
        openCalendarPage();
        calendarPage.openMenu(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
        viewWorkoutPage.findViewButton(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
        return this;
    }

    @Step
    public void checkingWorkoutsDetailsPageOpened() {
        validateComponentIsLoaded(viewWorkoutPage);
    }
}
