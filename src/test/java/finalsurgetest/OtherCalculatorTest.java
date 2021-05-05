package finalsurgetest;

import io.qameta.allure.Description;
import model.CaloricNeedsModel;
import model.PaceCalculatorModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OtherCalculatorTest extends BaseTest {

    CaloricNeedsModel caloricNeedsModel = new CaloricNeedsModel();
    PaceCalculatorModel paceCalculatorModel = new PaceCalculatorModel();

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
    }

    @Test
    @Description(value = "Calculate needs test")
    public void calculateNeedsTest() {
        initCaloricNeedsModel();
        loginSteps
                .openLoginPage()
                .authentication();
        caloricNeedsOtherCalSteps
                .openCaloricNeeds()
                .fillCaloricNeeds(caloricNeedsModel)
                .saveCalculateCaloricNeeds()
                .checkCalculation();
    }

    @Test
    @Description(value = "Pace Calculate test")
    public void paceCalculateTest() {
        initPaceCalculateModel();
        loginSteps
                .openLoginPage()
                .authentication();
        paceCalculatorOtherCalSteps
                .openPaceCalculator()
                .fillPaceCalculator(paceCalculatorModel)
                .saveCalculatePace()
                .checkCalculation();
    }

    private void initPaceCalculateModel() {
        paceCalculatorModel = new PaceCalculatorModel();
        //input
        paceCalculatorModel.setDistance("5");
        paceCalculatorModel.setTimeHours("01");
        paceCalculatorModel.setTimeMinutes("15");
        paceCalculatorModel.setTimeSeconds("20");

        //dropdown
        paceCalculatorModel.setDistType("Kilometers");
    }

    private void initCaloricNeedsModel() {
        caloricNeedsModel = new CaloricNeedsModel();
        //input
        caloricNeedsModel.setWeight("60");
        caloricNeedsModel.setHeight("180");
        caloricNeedsModel.setAge("25");
        caloricNeedsModel.setRunDistance("5");
    }

    @AfterMethod
    @Override
    public void tearDown() {
        driver.switchTo().defaultContent();
        super.tearDown();
    }
}
