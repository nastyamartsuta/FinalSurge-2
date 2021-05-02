package finalsurgetest;

import io.qameta.allure.Description;
import model.HansonsModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorkoutCalculatorTest extends BaseTest {

    HansonsModel hansonsModel = new HansonsModel();

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        initHansonsModel();
    }

    @Test
    @Description(value = "Calculate Training Pace test")
    public void calculateTrainingPaceTest() {
        loginSteps
                .openLoginPage()
                .authentication();
        calculatorSteps
                .openCalculatorPage()
                .openHansons()
                .fillHansons(hansonsModel);
        //  calculatorSteps.saveCalculatorPaces();

    }

    private void initHansonsModel() {
        hansonsModel = new HansonsModel();
        //input
        hansonsModel.setTimeHours("5");
        hansonsModel.setTimeMinutes("30");
        hansonsModel.setTimeSeconds("00");
        hansonsModel.setTemperature("15");
        hansonsModel.setWindSpeed("10");
        hansonsModel.setHumidity("80");

        //dropdown
        hansonsModel.setRaceDistance(4);
        hansonsModel.setTemperatureType(1);
        hansonsModel.setSpeedType(0);
    }

    @AfterMethod
    @Override
    public void tearDown() {
        driver.switchTo().defaultContent();
        super.tearDown();
    }
}

