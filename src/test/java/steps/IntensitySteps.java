package steps;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import model.IntensityModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IntensitySteps extends AbstractWorkoutCalculatorSteps {

    public IntensitySteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open intensity page")
    public IntensitySteps openIntensity() {
        openCalculatorPage();
        intensityPage.openPage();
        return this;
    }

    @Step("Fill in the Intensity fields")
    public IntensitySteps fillIntensity(IntensityModel intensityModel) {
        new Input(driver, "TimeHH").enterInput(intensityModel.getTimeHours());
        new Input(driver, "TimeMM").enterInput(intensityModel.getTimeMinutes());
        new Input(driver, "TimeSS").enterInput(intensityModel.getTimeSeconds());
        new RadioButton(driver, " 10Km").selectRadioButton();
        return this;
    }

    @Step("Calculate intensity paces")
    public IntensitySteps calculatePaces() {
        intensityPage.clickCalculatePacesButton();
        return this;
    }

    @Step("Checking intensity paces was opened")
    public void checkingCalculationWasOpened() {
        Assert.assertTrue(intensityPage.checkCalculationsIsOpened(), "Calculations did not open");
    }
}
