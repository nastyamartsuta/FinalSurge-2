package steps;

import elements.DropdownSelectByValue;
import elements.Input;
import io.qameta.allure.Step;
import model.McMillanModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class McMillanSteps extends AbstractWorkoutCalculatorSteps {

    public McMillanSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open McMillan page")
    public McMillanSteps openMcMillanPage() {
        openCalculatorPage();
        mcMillanPage.openPage();
        return this;
    }

    @Step("Fill in the McMillan fields")
    public McMillanSteps fillMcMillan() {
        new Input(driver, "TimeHH").enterInput(McMillanModel.recentTimeHours);
        new Input(driver, "TimeMM").enterInput(McMillanModel.recentTimeMinutes);
        new Input(driver, "TimeSS").enterInput(McMillanModel.recentTimeSeconds);
        new Input(driver, "GTimeHH").enterInput(McMillanModel.goalTimeHours);
        new Input(driver, "GTimeMM").enterInput(McMillanModel.goalTimeMinutes);
        new Input(driver, "GTimeSS").enterInput(McMillanModel.goalTimeSeconds);
        new DropdownSelectByValue(driver, "distance").select(McMillanModel.recentDistanceType);
        new DropdownSelectByValue(driver, "goaldistance").select(McMillanModel.goalDistanceType);
        return this;
    }

    @Step("Calculate McMillan paces")
    public McMillanSteps calculatePaces() {
        mcMillanPage.clickCalculatePacesButton();
        return this;
    }

    @Step("Checking McMillan calculation was opened")
    public void checkingCalculationWasOpened() {
        Assert.assertTrue(mcMillanPage.checkCalculationsIsOpened(), "Calculations did not open");
        Assert.assertEquals(mcMillanPage.getActualRecentDistance(), McMillanModel.recentDistanceType, "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualRecentHours(), McMillanModel.recentTimeHours, "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualRecentMinutes(), McMillanModel.recentTimeMinutes, "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualRecentSeconds(), McMillanModel.recentTimeSeconds, "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualGoalDistance(), McMillanModel.goalDistanceType, "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualGoalHours(), McMillanModel.goalTimeHours, "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualGoalMinutes(), McMillanModel.goalTimeMinutes, "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualGoalSeconds(), McMillanModel.goalTimeSeconds, "Incorrect text");
    }
}