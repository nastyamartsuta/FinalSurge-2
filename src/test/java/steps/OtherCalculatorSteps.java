package steps;

import elements.InputHansons;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import model.CaloricNeedsModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CaloricNeedsPage;
import pages.OtherCalculatorPage;


//TODO подумать как правильно переименовать степы
@Log4j2
public class OtherCalculatorSteps extends AbstractStep {

    OtherCalculatorPage otherCalculatorPage = new OtherCalculatorPage(driver);
    CaloricNeedsPage caloricNeedsPage = new CaloricNeedsPage(driver);

    public OtherCalculatorSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public OtherCalculatorSteps openOtherCalculatorPage() {
        otherCalculatorPage.openPage();
        validateComponentIsLoaded(otherCalculatorPage);
        return this;
    }

   @Step
    public OtherCalculatorSteps openCaloricNeeds() {
        caloricNeedsPage.openPage();
        return this;
    }

    @Step
    public OtherCalculatorSteps fillCaloricNeeds(CaloricNeedsModel caloricNeedsModel) {
        //input
        new InputHansons(driver, "Weight").enterInputHansons(caloricNeedsModel.getWeight());
        new InputHansons(driver, "HeightInchCent").enterInputHansons(caloricNeedsModel.getHeight());
        new InputHansons(driver, "Age").enterInputHansons(caloricNeedsModel.getAge());
        new InputHansons(driver, "RunDist").enterInputHansons(caloricNeedsModel.getRunDistance());

        //radiobutton
        new RadioButton(driver,"kg").selectRadioButton();
        new RadioButton(driver,"centimeters").selectRadioButton();
        new RadioButton(driver,"female").selectRadioButton();
        new RadioButton(driver,"kilometers").selectRadioButton();


        //TODO написать assert-ыЫы
        return this;
    }

    @Step
    public OtherCalculatorSteps saveCalculateCaloricNeeds() {
        caloricNeedsPage.saveCalculateCaloricNeeds();
        return this;
    }

    @Step
    public OtherCalculatorSteps checkCalculation() {
        //TODO
        Assert.assertTrue(otherCalculatorPage.checkCalculationsIsOpened(), "Calculations did not open");
        return this;
    }
}