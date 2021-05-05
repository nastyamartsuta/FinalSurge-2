package finalsurgetest;

import io.qameta.allure.Description;
import model.HansonsModel;
import model.IntensityModel;
import model.McMillanModel;
import model.TinmanModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorkoutCalculatorTest extends BaseTest {

    HansonsModel hansonsModel = new HansonsModel();
    IntensityModel intensityModel = new IntensityModel();
    TinmanModel tinmanModel = new TinmanModel();
    McMillanModel mcMillanModel = new McMillanModel();

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
    }

    @Test
    @Description(value = "Calculate Hansons test")
    public void calculateHansonsTest() {
        initHansonsModel();
        loginSteps
                .openLoginPage()
                .authentication();
        hansonsSteps
                .openHansons()
                .fillHansons(hansonsModel)
                .saveCalculatorPaces()
                .checkCalculation(hansonsModel);
    }

    @Test
    @Description(value = "Calculate Intensity test")
    public void calculateIntensityTest() {
        initIntensityModel();
        loginSteps
                .openLoginPage()
                .authentication();
        intensitySteps
                .openIntensity()
                .fillIntensity(intensityModel)
                .saveCalculatorPaces()
                .checkCalculation();
    }

    @Test
    @Description(value = "Calculate Tinman test")
    public void calculateTinmanTest() {
        initTinmanModel();
        loginSteps
                .openLoginPage()
                .authentication();
        tinmanSteps
                .openTinman()
                .fillITinman(tinmanModel)
                .saveCalculatorPaces()
                .checkCalculation(tinmanModel);
    }

    @Test
    @Description(value = "Calculate McMillan test")
    public void calculateMcMillanTest() {
        initMcMillanModel();
        loginSteps
                .openLoginPage()
                .authentication();
        mcMillanSteps
                .openMcMillan()
                .fillMcMillan(mcMillanModel)
                .saveCalculatorPaces()
                .checkCalculation(mcMillanModel);
    }


    private void initMcMillanModel() {
        mcMillanModel = new McMillanModel();

        //input
        mcMillanModel.setRecentTimeHours("1");
        mcMillanModel.setRecentTimeMinutes("20");
        mcMillanModel.setRecentTimeSeconds("30");

        mcMillanModel.setGoalTimeHours("1");
        mcMillanModel.setGoalTimeMinutes("05");
        mcMillanModel.setGoalTimeSeconds("10");

        //dropdown
        mcMillanModel.setRecentDistanceType("1500m");
        mcMillanModel.setGoalDistanceType("1500m");

    }

    private void initTinmanModel() {
        tinmanModel = new TinmanModel();
        //input
        tinmanModel.setTimeHours("00");
        tinmanModel.setTimeMinutes("30");
        tinmanModel.setTimeSeconds("00");

        //dropdown
        tinmanModel.setRaceDistance("0.4");

        //radiobutton
        tinmanModel.setGender("Female");
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
        hansonsModel.setRaceDistance("1500m");
        hansonsModel.setTemperatureType("C");
        hansonsModel.setSpeedType("mph");
    }

    private void initIntensityModel() {
        intensityModel = new IntensityModel();
        //input
        intensityModel.setTimeHours("1");
        intensityModel.setTimeMinutes("30");
        intensityModel.setTimeSeconds("00");
    }

    @AfterMethod
    @Override
    public void tearDown() {
        driver.switchTo().defaultContent();
        super.tearDown();
    }
}

