package finalsurgetest;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static pages.BasePage.*;
import static pages.CalendarPage.WORKOUTS;

public class AddWorkoutsTest extends WithLoginTest {

    @Test
    @Description(value = "Add workout test")
    public void addWorkoutsTest() {
        addWorkoutSteps
                .openAddWorkoutPanel()
                .fillNewWorkout()
                .saveNewWorkout()
                .checkingNewWorkoutWasAdded();
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .deleteWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
    }
}
