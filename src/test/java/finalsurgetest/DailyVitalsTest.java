package finalsurgetest;

import io.qameta.allure.Description;
import model.VitalsModel;
import org.testng.annotations.Test;

public class DailyVitalsTest extends BaseTest {

    VitalsModel vitalsModel = new VitalsModel();

    @Test
    @Description(value = "View vitals test")
    public void viewVitalsTest() {
        loginSteps
                .openLoginPage()
                .authentication();
        viewVitalsSteps
                .openViewPage()
                .viewLastMonthVitals();
    }

    @Test
    @Description(value = "Add vitals test")
    public void addVitalsTest() {
        initVitalsModel();
        loginSteps
                .openLoginPage()
                .authentication();
        addVitalsSteps
                .openAddVitals()
                .fillNewVitals(vitalsModel)
                .saveNewVitals()
                .checkingVitalsAdd(vitalsModel);
    }

    private void initVitalsModel() {
        vitalsModel = new VitalsModel();
        vitalsModel.setVitalsDate("5/11/2021");
        vitalsModel.setSteps("8000");
        vitalsModel.setWeight("70");
        vitalsModel.setCaloriesConsumed("1500");
        vitalsModel.setBodyFat("18.5");
        vitalsModel.setWater("10");
        vitalsModel.setMuscleMass("27");
        vitalsModel.setResting("80");
        vitalsModel.setVariability("80");
        vitalsModel.setSleepHours("8");
        vitalsModel.setTotalTimeAwake("16");
        vitalsModel.setSystolic("120");
        vitalsModel.setDiastolic("80");
        vitalsModel.setHealthNotes("The body is healthy");
        vitalsModel.setWeightType("kg");
        vitalsModel.setMuscleMassType("kg");
        vitalsModel.setSleepAmount("Enough");
        vitalsModel.setSleepQuality("Good");
        vitalsModel.setStressAmount("Moderate");
    }
}
