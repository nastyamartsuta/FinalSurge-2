package steps;

import elements.DropdownSelectByVisibleText;
import elements.Input;
import io.qameta.allure.Step;
import model.VitalsModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DailyVitalsPage;

public class AddVitalsSteps extends AbstractStep {

    DailyVitalsPage dailyVitalsPage = new DailyVitalsPage(driver);

    public AddVitalsSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public AddVitalsSteps openAddVitals() {
        dailyVitalsPage.openPage();
        validateComponentIsLoaded(dailyVitalsPage);
        dailyVitalsPage.openDailyVitalsAddPanel();
        return this;
    }

    @Step
    public AddVitalsSteps fillNewVitals(VitalsModel vitalsModel) {
        new Input(driver, "VitalsDate").enterInput(vitalsModel.getVitalsDate());
        new Input(driver, "Steps").enterInput(vitalsModel.getSteps());
        new Input(driver, "Weight").enterInput(vitalsModel.getWeight());
        new Input(driver, "Calories").enterInput(vitalsModel.getCaloriesConsumed());
        new Input(driver, "BodyFat").enterInput(vitalsModel.getBodyFat());
        new Input(driver, "WaterPercent").enterInput(vitalsModel.getWater());
        new Input(driver, "MuscleMass").enterInput(vitalsModel.getMuscleMass());
        new Input(driver, "RestHR").enterInput(vitalsModel.getResting());
        new Input(driver, "HRVar").enterInput(vitalsModel.getVariability());
        new Input(driver, "SleepHours").enterInput(vitalsModel.getSleepHours());
        new Input(driver, "AwakeTime").enterInput(vitalsModel.getTotalTimeAwake());
        new Input(driver, "Systolic").enterInput(vitalsModel.getSystolic());
        new Input(driver, "Diastolic").enterInput(vitalsModel.getDiastolic());
        new Input(driver, "HealthNotes").enterInput(vitalsModel.getHealthNotes());
        new DropdownSelectByVisibleText(driver, "WeightType").select(vitalsModel.getWeightType());
        new DropdownSelectByVisibleText(driver, "MuscleMassType").select(vitalsModel.getMuscleMassType());
        new DropdownSelectByVisibleText(driver, "SleepAmount").select(vitalsModel.getSleepAmount());
        new DropdownSelectByVisibleText(driver, "SleepQuality").select(vitalsModel.getSleepQuality());
        new DropdownSelectByVisibleText(driver, "Stress").select(vitalsModel.getStressAmount());
        return this;
    }

    @Step
    public AddVitalsSteps saveNewVitals() {
        dailyVitalsPage.clickAddVitalsButton();
        return this;
    }

    //TODO
    @Step
    public void checkingVitalsAdd(VitalsModel vitalsModel) {
        Assert.assertTrue(dailyVitalsPage.getActualText(vitalsModel).contains(
                vitalsModel.getVitalsDate() + " " + vitalsModel.getSteps() + " " + vitalsModel.getWeight()
                        + " " + vitalsModel.getWeightType() + " " + vitalsModel.getBodyFat() + "% " +
                        vitalsModel.getResting() + " bpm " + vitalsModel.getVariability() + " " + vitalsModel.getCaloriesConsumed() + " kCal " +
                        vitalsModel.getWater() + "% " + vitalsModel.getMuscleMass() + " " + vitalsModel.getMuscleMassType()
                        + " " + vitalsModel.getSleepHours() + " hrs " + vitalsModel.getTotalTimeAwake() + " hrs " +
                        vitalsModel.getSleepAmount() + " " + vitalsModel.getSleepQuality() + " " + vitalsModel.getStressAmount()
                        + " " + vitalsModel.getSystolic() + " / " + vitalsModel.getDiastolic() + " mm Hg " + vitalsModel.getHealthNotes()
                ),
                "Incorrect text");
    }
}
