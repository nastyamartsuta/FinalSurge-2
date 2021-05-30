package finalsurgetest;

import io.qameta.allure.Description;
import model.SwimWorkoutModel;
import org.testng.annotations.Test;

import static pages.BasePage.*;
import static pages.CalendarPage.WORKOUTS;

public class AddWorkoutsTest extends WithLoginTest {

    SwimWorkoutModel swimWorkoutModel = new SwimWorkoutModel();

    @Test
    @Description(value = "Add workout test")
    public void addWorkoutsTest() {
        initSwimWorkoutModel();
        addWorkoutSteps
                .openAddWorkoutPanel()
                .fillNewWorkout(swimWorkoutModel)
                .saveNewWorkout()
                .checkingNewWorkoutWasAdded(swimWorkoutModel);
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .deleteWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);

    }

    private void initSwimWorkoutModel() {
        swimWorkoutModel = new SwimWorkoutModel();
        swimWorkoutModel.setDate("05/30/2021");
        swimWorkoutModel.setWorkoutTime("8:00 AM");
        swimWorkoutModel.setWorkoutName("Swim");
        swimWorkoutModel.setDistance("100.00");
        swimWorkoutModel.setDuration("40:05:30");
        swimWorkoutModel.setPace("24:03");
        swimWorkoutModel.setCaloriesBurned("100");
        swimWorkoutModel.setWorkoutDescription("Morning workout");
        swimWorkoutModel.setDistanceType("km");
        swimWorkoutModel.setPaceType("min/km");
        swimWorkoutModel.setPerceivedEffort("4 (Moderate)");
    }
}
