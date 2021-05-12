package finalsurgetest;

import io.qameta.allure.Description;
import model.SwimWorkoutModel;
import org.testng.annotations.Test;

public class AddWorkoutsTest extends BaseTest {

   SwimWorkoutModel swimWorkoutModel = new SwimWorkoutModel();

    @Test
    @Description(value = "View vitals test")
    public void viewVitalsTest() {
        initSwimWorkoutModel();
        loginSteps
                .openLoginPage()
                .authentication();
        addWorkoutSteps.openAddWorkoutPanel()
                .fillNewWorkoutSwim(swimWorkoutModel)
                .saveNewWorkout()
                .checkingNewWorkoutAdd(swimWorkoutModel);
    }

    private void initSwimWorkoutModel() {
        swimWorkoutModel = new SwimWorkoutModel();
        swimWorkoutModel.setDate("05/13/2021");
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
