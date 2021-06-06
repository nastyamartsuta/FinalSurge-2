package steps;

import elements.DropdownSelectByVisibleText;
import elements.Input;
import io.qameta.allure.Step;
import model.VitalsModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DailyVitalsPage;

public class AddDailyVitalsSteps extends AbstractStep {

    DailyVitalsPage dailyVitalsPage = new DailyVitalsPage(driver);

    public AddDailyVitalsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open add daily vitals page")
    public AddDailyVitalsSteps openAddDailyVitals() {
        dailyVitalsPage.openPage();
        validateComponentIsLoaded(dailyVitalsPage);
        dailyVitalsPage.openDailyVitalsAddPanel();
        return this;
    }

    @Step("Fill in the fields to add new daily vitals")
    public AddDailyVitalsSteps fillNewDailyVitals() {
        new Input(driver, "VitalsDate").enterInput(VitalsModel.vitalsDate);
        new Input(driver, "Steps").enterInput(VitalsModel.steps);
        new Input(driver, "Weight").enterInput(VitalsModel.weight);
        new Input(driver, "Calories").enterInput(VitalsModel.caloriesConsumed);
        new Input(driver, "BodyFat").enterInput(VitalsModel.bodyFat);
        new Input(driver, "WaterPercent").enterInput(VitalsModel.water);
        new Input(driver, "MuscleMass").enterInput(VitalsModel.muscleMass);
        new Input(driver, "RestHR").enterInput(VitalsModel.resting);
        new Input(driver, "HRVar").enterInput(VitalsModel.variability);
        new Input(driver, "SleepHours").enterInput(VitalsModel.sleepHours);
        new Input(driver, "AwakeTime").enterInput(VitalsModel.totalTimeAwake);
        new Input(driver, "Systolic").enterInput(VitalsModel.systolic);
        new Input(driver, "Diastolic").enterInput(VitalsModel.diastolic);
        new Input(driver, "HealthNotes").enterInput(VitalsModel.healthNotes);
        new DropdownSelectByVisibleText(driver, "WeightType").select(VitalsModel.weightType);
        new DropdownSelectByVisibleText(driver, "MuscleMassType").select(VitalsModel.muscleMassType);
        new DropdownSelectByVisibleText(driver, "SleepAmount").select(VitalsModel.sleepAmount);
        new DropdownSelectByVisibleText(driver, "SleepQuality").select(VitalsModel.sleepQuality);
        new DropdownSelectByVisibleText(driver, "Stress").select(VitalsModel.stressAmount);
        return this;
    }

    @Step("Save new daily vitals")
    public AddDailyVitalsSteps saveNewDailyVitals() {
        dailyVitalsPage.clickAddVitalsButton();
        return this;
    }

    @Step("Show this year daily vitals")
    public AddDailyVitalsSteps showThisYear() {
        dailyVitalsPage.showThisYearVitals();
        return this;
    }

    @Step("Checking that the new daily vitals was added")
    public void checkingNewDailyVitalsWasAdded() {
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsData(), VitalsModel.vitalsDate, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsSteps(), VitalsModel.steps, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsWeight(), VitalsModel.weight, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsWeightType(), VitalsModel.weightType, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsBodyFat(), VitalsModel.bodyFat, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsResting(), VitalsModel.resting, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsHRV(), VitalsModel.variability, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsCalories(), VitalsModel.caloriesConsumed, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsWater(), VitalsModel.water, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsMuscleMass(), VitalsModel.muscleMass, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsMuscleMassType(), VitalsModel.muscleMassType, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsSleep(), VitalsModel.sleepHours, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsAwake(), VitalsModel.totalTimeAwake, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsSleepAmount(), VitalsModel.sleepAmount, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsSleepQuality(), VitalsModel.sleepQuality, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsStress(), VitalsModel.stressAmount, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsBloodPressureSystolic(), VitalsModel.systolic, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsBloodPressureDiastolic(), VitalsModel.diastolic, "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsNotes(), VitalsModel.healthNotes, "Incorrect text");
    }
}
