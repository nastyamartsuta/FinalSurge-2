package finalsurgetest;

import io.qameta.allure.Description;
import model.WorkoutQuickModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalenderTest extends BaseTest {

    //TODO дописать тесты на календарь

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
                .openNewWorkoutQuickPage()
                .fillNewWorkoutQuickPage(workoutQuickModel)
                .saveNewWorkout()
                .checkingVitalsAdd(workoutQuickModel);
    }

    @Test
    @Description(value = "Open workout library test")
    public void openLibraryTest() {
        loginSteps
                .openLoginPage()
                .authentication();
        openWorkoutLibrarySteps
                .openWorkoutLibraryPanel()
                .selectActivityTypeFilter()
                .checkingLibraryIsOpen();
    }

    private void initWorkoutQuick() {
        workoutQuickModel = new WorkoutQuickModel();
        //input
        workoutQuickModel.setName("Run");
        workoutQuickModel.setWorkoutDate("5/11/2021");
        workoutQuickModel.setDistance("5");
        workoutQuickModel.setDuration("60");
        workoutQuickModel.setPace("12000");
        //textarea
        workoutQuickModel.setWorkoutDescription("Warm-up, run, stretching");
        workoutQuickModel.setResults("Check pulse and blood pressure");
        //dropdown
        workoutQuickModel.setDistanceType("km");
        workoutQuickModel.setPaceType("km");
        workoutQuickModel.setHowFeel("2");
        workoutQuickModel.setPerceivedEffort("3");
        workoutQuickModel.setActivityType("Run");
        //autocomplete
        workoutQuickModel.setTimeOfDay("06:15 AM");
    }
}