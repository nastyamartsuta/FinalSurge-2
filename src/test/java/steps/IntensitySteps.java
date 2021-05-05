package steps;

import elements.Dropdown;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import model.IntensityModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.IntensityPage;

public class IntensitySteps extends AbstractWorkoutCalculatorSteps {


    public IntensitySteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public IntensitySteps openIntensity() {
        openCalculatorPage();
        intensityPage.openPage();
        return this;
    }

    @Step
    public IntensitySteps fillIntensity(IntensityModel intensityModel) {
        //input
        new Input(driver, "TimeHH").enterInput(intensityModel.getTimeHours());
        new Input(driver, "TimeMM").enterInput(intensityModel.getTimeMinutes());
        new Input(driver, "TimeSS").enterInput(intensityModel.getTimeSeconds());

        //radiobutton
        new RadioButton(driver, " 10Km").selectRadioButton();
        return this;
    }

    @Step
    public IntensitySteps saveCalculatorPaces() {
        intensityPage.clickCalculatePacesButton();
        return this;
    }

    @Step
    public void checkCalculation() {
        Assert.assertTrue(intensityPage.checkCalculationsIsOpened(), "Calculations did not open");
    }
}
