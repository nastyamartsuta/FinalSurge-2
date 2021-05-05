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

    @Step
    public CaloricNeedsOtherCalSteps openCaloricNeeds() {
        openOtherCalculatorPage();
        caloricNeedsPage.openPage();
        return this;
    }

    @Step
    public CaloricNeedsOtherCalSteps fillCaloricNeeds(CaloricNeedsModel caloricNeedsModel) {
        //input
        new Input(driver, "Weight").enterInput(caloricNeedsModel.getWeight());
        new Input(driver, "HeightInchCent").enterInput(caloricNeedsModel.getHeight());
        new Input(driver, "Age").enterInput(caloricNeedsModel.getAge());
        new Input(driver, "RunDist").enterInput(caloricNeedsModel.getRunDistance());

        //radiobutton
        new RadioButton(driver, "kg").selectRadioButton();
        new RadioButton(driver, "centimeters").selectRadioButton();
        new RadioButton(driver, "female").selectRadioButton();
        new RadioButton(driver, "kilometers").selectRadioButton();
        return this;
    }

    @Step
    public CaloricNeedsOtherCalSteps saveCalculateCaloricNeeds() {
        caloricNeedsPage.saveCalculateCaloricNeeds();
        return this;
    }

    @Step
    public void checkCalculation() {
        Assert.assertTrue(caloricNeedsPage.checkCalculationsIsOpened(), "Calculations did not open");
    }
}