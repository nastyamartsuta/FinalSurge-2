package steps;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import model.PaceCalculatorModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.PaceCalculatePage;

public class PaceCalculatorOtherCalSteps extends AbstractOtherCalculatorSteps {

    PaceCalculatePage paceCalculatePage = new PaceCalculatePage(driver);

    public PaceCalculatorOtherCalSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public PaceCalculatorOtherCalSteps openPaceCalculator() {
        openOtherCalculatorPage();
        paceCalculatePage.openPage();
        return this;
    }

    @Step
    public PaceCalculatorOtherCalSteps fillPaceCalculator(PaceCalculatorModel paceCalculatorModel) {

        new Input(driver, "RunDist").enterInput(paceCalculatorModel.getDistance());
        new Input(driver, "TimeHH").enterInput(paceCalculatorModel.getTimeHours());
        new Input(driver, "TimeMM").enterInput(paceCalculatorModel.getTimeMinutes());
        new Input(driver, "TimeSS").enterInput(paceCalculatorModel.getTimeSeconds());
        new Dropdown(driver, "DistType").select(paceCalculatorModel.getDistType());
        return this;
    }

    @Step
    public PaceCalculatorOtherCalSteps saveCalculatePace() {
        paceCalculatePage.saveCalculatePaces();
        return this;
    }

    @Step
    public void checkCalculation() {
        Assert.assertTrue(paceCalculatePage.checkCalculationsIsOpened(), "Calculations did not open");
    }
}
