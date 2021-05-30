package steps;

import elements.DropdownSelectByValue;
import elements.Input;
import io.qameta.allure.Step;
import model.McMillanModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.StringUtils;

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
    public McMillanSteps fillMcMillan(McMillanModel mcMillanModel) {
        new Input(driver, "TimeHH").enterInput(mcMillanModel.getRecentTimeHours());
        new Input(driver, "TimeMM").enterInput(mcMillanModel.getRecentTimeMinutes());
        new Input(driver, "TimeSS").enterInput(mcMillanModel.getRecentTimeSeconds());
        new Input(driver, "GTimeHH").enterInput(mcMillanModel.getGoalTimeHours());
        new Input(driver, "GTimeMM").enterInput(mcMillanModel.getGoalTimeMinutes());
        new Input(driver, "GTimeSS").enterInput(mcMillanModel.getGoalTimeSeconds());
        new DropdownSelectByValue(driver, "distance").select(mcMillanModel.getRecentDistanceType());
        new DropdownSelectByValue(driver, "goaldistance").select(mcMillanModel.getGoalDistanceType());
        return this;
    }

    @Step("Calculate McMillan paces")
    public McMillanSteps calculatePaces() {
        mcMillanPage.clickCalculatePacesButton();
        return this;
    }
    
    @Step("Checking McMillan calculation was opened")
    public void checkingCalculationWasOpened(McMillanModel mcMillanModel) {
        Assert.assertTrue(mcMillanPage.checkCalculationsIsOpened(), "Calculations did not open");
        Assert.assertEquals(mcMillanPage.getActualRecentDistance(), mcMillanModel.getRecentDistanceType(), "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualRecentHours(), mcMillanModel.getRecentTimeHours(), "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualRecentMinutes(), mcMillanModel.getRecentTimeMinutes(), "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualRecentSeconds(), mcMillanModel.getRecentTimeSeconds(), "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualGoalDistance(), mcMillanModel.getGoalDistanceType(), "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualGoalHours(), mcMillanModel.getGoalTimeHours(), "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualGoalMinutes(), mcMillanModel.getGoalTimeMinutes(), "Incorrect text");
        Assert.assertEquals(mcMillanPage.getActualGoalSeconds(), mcMillanModel.getGoalTimeSeconds(), "Incorrect text");
    }
}