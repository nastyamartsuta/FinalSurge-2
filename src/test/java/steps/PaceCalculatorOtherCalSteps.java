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

    @Step("Open pace calculator")
    public PaceCalculatorOtherCalSteps openPaceCalculator() {
        openOtherCalculatorPage();
        paceCalculatePage.openPage();
        return this;
    }

    @Step("Fill in the Pace calculator fields")
    public PaceCalculatorOtherCalSteps fillPaceCalculator() {
        new Input(driver, "RunDist").enterInput(PaceCalculatorModel.distance);
        new Input(driver, "TimeHH").enterInput(PaceCalculatorModel.timeHours);
        new Input(driver, "TimeMM").enterInput(PaceCalculatorModel.timeMinutes);
        new Input(driver, "TimeSS").enterInput(PaceCalculatorModel.timeSeconds);
        new Dropdown(driver, "DistType").select(PaceCalculatorModel.distType);
        return this;
    }

    @Step("Calculate paces")
    public PaceCalculatorOtherCalSteps calculatePaces() {
        paceCalculatePage.calculatePaces();
        return this;
    }

    @Step("Checking calculation was opened")
    public void checkingCalculationWasOpened() {
        Assert.assertTrue(paceCalculatePage.checkCalculationsWasOpened(), "Calculations did not open");
    }
}
