package steps;

import elements.DropdownTinman;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import model.TinmanModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TinmanSteps extends AbstractWorkoutCalculatorSteps {

    public TinmanSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open Tinman page")
    public TinmanSteps openTinmanPage() {
        openCalculatorPage();
        tinmanPage.openPage();
        return this;
    }

    @Step("Fill in the Tinman fields")
    public TinmanSteps fillITinman() {
        new Input(driver, "TimeHH").enterInput(TinmanModel.timeHours);
        new Input(driver, "TimeMM").enterInput(TinmanModel.timeMinutes);
        new Input(driver, "TimeSS").enterInput(TinmanModel.timeSeconds);
        new RadioButton(driver, " Female").selectRadioButton();
        new DropdownTinman(driver, "Select...").select(TinmanModel.raceDistance);
        return this;
    }

    @Step("Calculate Tinman paces")
    public TinmanSteps calculatePaces() {
        tinmanPage.clickCalculatePacesButton();
        return this;
    }

    @Step("Checking Tinman calculation was opened")
    public void checkingCalculationWasOpened() {
        Assert.assertTrue(tinmanPage.checkCalculationsIsOpened(), "Calculations did not open");
        Assert.assertEquals(tinmanPage.getActualHours(), TinmanModel.timeHours, "Incorrect text");
        Assert.assertEquals(tinmanPage.getActualMinutes(), TinmanModel.timeMinutes, "Incorrect text");
        Assert.assertEquals(tinmanPage. getActualSeconds(), TinmanModel.timeSeconds, "Incorrect text");
        Assert.assertEquals(tinmanPage.getActualGender(), TinmanModel.gender, "Incorrect text");
    }
}
