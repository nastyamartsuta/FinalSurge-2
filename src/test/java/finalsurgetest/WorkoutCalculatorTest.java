package finalsurgetest;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WorkoutCalculatorTest extends WithLoginTest {

    @Test
    @Description(value = "Calculate Hansons test")
    public void calculateHansonsTest() {
        hansonsSteps
                .openHansonsPage()
                .fillHansons()
                .calculatePaces()
                .checkingCalculationWasOpened();
    }

    @Test
    @Description(value = "Calculate Intensity test")
    public void calculateIntensityTest() {
        intensitySteps
                .openIntensity()
                .fillIntensity()
                .calculatePaces()
                .checkingCalculationWasOpened();
    }

    @Test
    @Description(value = "Calculate Tinman test")
    public void calculateTinmanTest() {
        tinmanSteps
                .openTinmanPage()
                .fillITinman()
                .calculatePaces()
                .checkingCalculationWasOpened();
    }

    @Test
    @Description(value = "Calculate McMillan test")
    public void calculateMcMillanTest() {
        mcMillanSteps
                .openMcMillanPage()
                .fillMcMillan()
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

