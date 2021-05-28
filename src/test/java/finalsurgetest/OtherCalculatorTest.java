package finalsurgetest;

import io.qameta.allure.Description;
import model.CaloricNeedsModel;
import model.PaceCalculatorModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class OtherCalculatorTest extends WithLoginTest {

    CaloricNeedsModel caloricNeedsModel = new CaloricNeedsModel();
    PaceCalculatorModel paceCalculatorModel = new PaceCalculatorModel();


    @Test
    @Description(value = "Calculate needs test")
    public void calculateNeedsTest() {
        initCaloricNeedsModel();
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
        paceCalculatorOtherCalSteps
                .openPaceCalculator()
                .fillPaceCalculator(paceCalculatorModel)
                .saveCalculatePace()
                .checkCalculation();
    }

    private void initPaceCalculateModel() {
        paceCalculatorModel = new PaceCalculatorModel();
        paceCalculatorModel.setDistance("5");
        paceCalculatorModel.setTimeHours("01");
        paceCalculatorModel.setTimeMinutes("15");
        paceCalculatorModel.setTimeSeconds("20");
        paceCalculatorModel.setDistType("km");
    }

    private void initCaloricNeedsModel() {
        caloricNeedsModel = new CaloricNeedsModel();
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
