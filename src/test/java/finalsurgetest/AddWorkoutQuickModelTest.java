package finalsurgetest;

import io.qameta.allure.Description;
import model.WorkoutQuickModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddWorkoutQuickModelTest extends BaseTest {

    WorkoutQuickModel workoutQuickModel;

    @BeforeMethod
    public void initTestData() {
        initWorkoutQuick();
    }

    @Test
    @Description(value = "Add workout quick test")
    public void addWorkoutQuickTest() {
        loginSteps
                .openLoginPage()
                .authentication();
        addWorkoutQuickSteps
                .openCalendarPage()
                .openNewWorkoutQuickPage()
                .fillNewWorkoutQuickPage(workoutQuickModel);
        addWorkoutQuickSteps.saveNewWorkout();

    }

    private void initWorkoutQuick() {
        workoutQuickModel = new WorkoutQuickModel();
        //input
        workoutQuickModel.setName("Run");
        workoutQuickModel.setWorkoutDate("09/05/2021");
        workoutQuickModel.setDistance("5");
        workoutQuickModel.setDuration("60");
        workoutQuickModel.setPace("12000");
        //textarea
        workoutQuickModel.setWorkoutDescription("Warm-up, run, stretching");
        workoutQuickModel.setResults("Check pulse and blood pressure");
        //dropdown
        workoutQuickModel.setDistanceType("km");
        workoutQuickModel.setPaceType("min/km");
        workoutQuickModel.setHowFeel("Good");
        workoutQuickModel.setPerceivedEffort("3 (Light)");
        workoutQuickModel.setActivityType("Run");
        //autocomplete
        workoutQuickModel.setTimeOfDay("06:15 AM");

    }
}