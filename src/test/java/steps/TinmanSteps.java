package steps;

import elements.DropdownTinman;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import model.TinmanModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TinmanSteps extends AbstractWorkoutCalculatorSteps {

    private static final String ACTUAL_TIME = "//h4[contains(.,'Race Information')]/ancestor::div[@class='w-box w-box-green']//tbody//td[2]";
    private static final String ACTUAL_GENDER = "//h4[contains(.,'Race Information')]/ancestor::div[@class='w-box w-box-green']//tbody//td[3]";

    public TinmanSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public TinmanSteps openTinman() {
        openCalculatorPage();
        tinmanPage.openPage();
        return this;
    }

    @Step
    public TinmanSteps fillITinman(TinmanModel tinmanModel) {

        new Input(driver, "TimeHH").enterInput(tinmanModel.getTimeHours());
        new Input(driver, "TimeMM").enterInput(tinmanModel.getTimeMinutes());
        new Input(driver, "TimeSS").enterInput(tinmanModel.getTimeSeconds());
        new RadioButton(driver, " Female").selectRadioButton();
        new DropdownTinman(driver).select(tinmanModel.getRaceDistance());
        return this;
    }

    @Step
    public TinmanSteps saveCalculatorPaces() {
        tinmanPage.clickCalculatePacesButton();
        return this;
    }

    @Step
    public void checkCalculation(TinmanModel tinmanModel) {
        Assert.assertTrue(tinmanPage.checkCalculationsIsOpened(), "Calculations did not open");
        Assert.assertEquals(driver.findElement(By.xpath(ACTUAL_TIME)).getText(),  tinmanModel.getTimeMinutes()
                + ":" +tinmanModel.getTimeSeconds(), "Entered data is not displayed");
        Assert.assertEquals(driver.findElement(By.xpath(ACTUAL_GENDER)).getText(), tinmanModel.getGender(),"Entered data is not displayed" );
    }
}
