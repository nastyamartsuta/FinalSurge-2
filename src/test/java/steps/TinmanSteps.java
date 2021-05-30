package steps;

import elements.DropdownTinman;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import model.TinmanModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public TinmanSteps fillITinman(TinmanModel tinmanModel) {
        new Input(driver, "TimeHH").enterInput(tinmanModel.getTimeHours());
        new Input(driver, "TimeMM").enterInput(tinmanModel.getTimeMinutes());
        new Input(driver, "TimeSS").enterInput(tinmanModel.getTimeSeconds());
        new RadioButton(driver, " Female").selectRadioButton();
        new DropdownTinman(driver, "Select...").select(tinmanModel.getRaceDistance());
        return this;
    }

    @Step("Calculate Tinman paces")
    public TinmanSteps calculatePaces() {
        tinmanPage.clickCalculatePacesButton();
        return this;
    }

    @Step("Checking Tinman calculation was opened")
    public void checkingCalculationWasOpened(TinmanModel tinmanModel) {
        Assert.assertTrue(tinmanPage.checkCalculationsIsOpened(), "Calculations did not open");
        Assert.assertEquals(tinmanPage.getActualHours(), tinmanModel.getTimeHours(), "Incorrect text");
        Assert.assertEquals(tinmanPage.getActualMinutes(), tinmanModel.getTimeMinutes(), "Incorrect text");
        Assert.assertEquals(tinmanPage. getActualSeconds(), tinmanModel.getTimeSeconds(), "Incorrect text");
        Assert.assertEquals(tinmanPage.getActualGender(), tinmanModel.getGender(), "Incorrect text");
    }
}
