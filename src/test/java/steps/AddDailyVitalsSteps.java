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
    public AddDailyVitalsSteps fillNewDailyVitals(VitalsModel vitalsModel) {
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
    public void checkingNewDailyVitalsWasAdded(VitalsModel vitalsModel) {
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsData(vitalsModel), vitalsModel.getVitalsDate(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsSteps(vitalsModel), vitalsModel.getSteps(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsWeight(vitalsModel), vitalsModel.getWeight(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsWeightType(vitalsModel), vitalsModel.getWeightType(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsBodyFat(vitalsModel), vitalsModel.getBodyFat(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsResting(vitalsModel), vitalsModel.getResting(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsHRV(vitalsModel), vitalsModel.getVariability(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsCalories(vitalsModel), vitalsModel.getCaloriesConsumed(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsWater(vitalsModel), vitalsModel.getWater(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsMuscleMass(vitalsModel), vitalsModel.getMuscleMass(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsMuscleMassType(vitalsModel), vitalsModel.getMuscleMassType(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsSleep(vitalsModel), vitalsModel.getSleepHours(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsAwake(vitalsModel), vitalsModel.getTotalTimeAwake(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsSleepAmount(vitalsModel), vitalsModel.getSleepAmount(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsSleepQuality(vitalsModel), vitalsModel.getSleepQuality(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsStress(vitalsModel), vitalsModel.getStressAmount(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsBloodPressureSystolic(vitalsModel), vitalsModel.getSystolic(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsBloodPressureDiastolic(vitalsModel), vitalsModel.getDiastolic(), "Incorrect text");
        Assert.assertEquals(dailyVitalsPage.getActualDailyVitalsNotes(vitalsModel), vitalsModel.getHealthNotes(), "Incorrect text");
    }
}
