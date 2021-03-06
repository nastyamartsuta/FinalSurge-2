package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.MoveWorkoutPage;

import static pages.BasePage.*;
import static pages.CalendarPage.WORKOUTS;

public class MoveWorkoutSteps extends AbstractCalendarPageSteps {

    private String newDay;

    public MoveWorkoutSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open move workout menu")
    public MoveWorkoutSteps openMoveMenu() {
        moveWorkoutPage = new MoveWorkoutPage(driver);
        openCalendarPage();
        calendarPage.openMenu(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
        moveWorkoutPage.findMoveWorkoutButton(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
        return this;
    }

    @Step("Move workout")
    public MoveWorkoutSteps moveWorkout() {
        newDay = moveWorkoutPage.selectNewWorkoutDay();
        return this;
    }

    @Step("Checking workouts was moved")
    public void checkingWorkoutsWasMoved() {
        Assert.assertTrue(moveWorkoutPage.checkingWorkoutWasMoved(MONTH_PATTERN, newDay, YEAR_PATTERN),
                "Workout wasn't moved");
        Assert.assertTrue(moveWorkoutPage.checkingPreviousDataIsNull(),
                "Workout wasn't moved");
    }
}



