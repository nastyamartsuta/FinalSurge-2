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

    @Step
    public McMillanSteps openMcMillan() {
        openCalculatorPage();
        mcMillanPage.openPage();
        return this;
    }

    @Step
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

    @Step
    public McMillanSteps saveCalculatorPaces() {
        mcMillanPage.clickCalculatePacesButton();
        return this;
    }

    //TODO
    @Step
    public void checkCalculation(McMillanModel mcMillanModel) {
        Assert.assertTrue(mcMillanPage.checkCalculationsIsOpened(), "Calculations did not open");
        Assert.assertTrue(mcMillanPage.text().contains("Recent Race: "
                        + mcMillanModel.getRecentDistanceType() + " time of "
                        + mcMillanModel.getRecentTimeHours() + ":"
                        + mcMillanModel.getRecentTimeMinutes() + ":"
                        + mcMillanModel.getRecentTimeSeconds()),
                "Incorrect text");
        Assert.assertTrue(mcMillanPage.text().contains("Goal Race: "
                        + mcMillanModel.getGoalDistanceType() + " time of "
                        + mcMillanModel.getGoalTimeHours() + ":"
                        + mcMillanModel.getGoalTimeMinutes() + ":"
                        + mcMillanModel.getGoalTimeSeconds()),
                "Incorrect text");
    }
}