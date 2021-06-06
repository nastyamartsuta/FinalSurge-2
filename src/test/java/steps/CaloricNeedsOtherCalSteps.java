package steps;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import model.CaloricNeedsModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CaloricNeedsPage;

@Log4j2
public class CaloricNeedsOtherCalSteps extends AbstractOtherCalculatorSteps {

    CaloricNeedsPage caloricNeedsPage = new CaloricNeedsPage(driver);

    public CaloricNeedsOtherCalSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open caloric needs page")
    public CaloricNeedsOtherCalSteps openCaloricNeeds() {
        openOtherCalculatorPage();
        caloricNeedsPage.openPage();
        return this;
    }

    @Step("Fill in the Caloric needs fields")
    public CaloricNeedsOtherCalSteps fillCaloricNeeds() {
        new Input(driver, "Weight").enterInput(CaloricNeedsModel.weight);
        new Input(driver, "HeightInchCent").enterInput(CaloricNeedsModel.height);
        new Input(driver, "Age").enterInput(CaloricNeedsModel.age);
        new Input(driver, "RunDist").enterInput(CaloricNeedsModel.runDistance);
        new RadioButton(driver, "kg").selectRadioButton();
        new RadioButton(driver, "centimeters").selectRadioButton();
        new RadioButton(driver, "female").selectRadioButton();
        new RadioButton(driver, "kilometers").selectRadioButton();
        return this;
    }

    @Step("Calculate caloric needs")
    public CaloricNeedsOtherCalSteps calculateCaloricNeeds() {
        caloricNeedsPage.saveCalculateCaloricNeeds();
        return this;
    }

    @Step("Checking calculation was opened")
    public void checkingCalculationWasOpened() {
        Assert.assertTrue(caloricNeedsPage.checkCalculationsIsOpened(), "Calculations did not open");
    }
}