package finalsurgetest;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class OtherCalculatorTest extends WithLoginTest {

    @Test
    @Description(value = "Calculate needs test")
    public void calculateNeedsTest() {
        caloricNeedsOtherCalSteps
                .openCaloricNeeds()
                .fillCaloricNeeds()
                .calculateCaloricNeeds()
                .checkingCalculationWasOpened();
    }

    @Test
    @Description(value = "Pace Calculate test")
    public void paceCalculateTest() {
        paceCalculatorOtherCalSteps
                .openPaceCalculator()
                .fillPaceCalculator()
                .calculatePaces()
                .checkingCalculationWasOpened();
    }

    @AfterMethod
    @Override
    public void tearDown() {
        driver.switchTo().defaultContent();
        super.tearDown();
    }
}
