package finalsurgetest;

import io.qameta.allure.Description;
import model.HansonsModel;
import model.IntensityModel;
import model.McMillanModel;
import model.TinmanModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WorkoutCalculatorTest extends WithLoginTest {

    HansonsModel hansonsModel = new HansonsModel();
    IntensityModel intensityModel = new IntensityModel();
    TinmanModel tinmanModel = new TinmanModel();
    McMillanModel mcMillanModel = new McMillanModel();

    @Test
    @Description(value = "Calculate Hansons test")
    public void calculateHansonsTest() {
        initHansonsModel();
        hansonsSteps
                .openHansonsPage()
                .fillHansons(hansonsModel)
                .calculatePaces()
                .checkingCalculationWasOpened(hansonsModel);
    }

    @Test
    @Description(value = "Calculate Intensity test")
    public void calculateIntensityTest() {
        initIntensityModel();
        intensitySteps
                .openIntensity()
                .fillIntensity(intensityModel)
                .calculatePaces()
                .checkingCalculationWasOpened();
    }

    @Test
    @Description(value = "Calculate Tinman test")
    public void calculateTinmanTest() {
        initTinmanModel();
        tinmanSteps
                .openTinmanPage()
                .fillITinman(tinmanModel)
                .calculatePaces()
                .checkingCalculationWasOpened(tinmanModel);
    }

    @Test
    @Description(value = "Calculate McMillan test")
    public void calculateMcMillanTest() {
        initMcMillanModel();
        mcMillanSteps
                .openMcMillanPage()
                .fillMcMillan(mcMillanModel)
                .calculatePaces()
                .checkingCalculationWasOpened(mcMillanModel);
    }


    private void initMcMillanModel() {
        mcMillanModel = new McMillanModel();
        mcMillanModel.setRecentTimeHours("1");
        mcMillanModel.setRecentTimeMinutes("20");
        mcMillanModel.setRecentTimeSeconds("30");
        mcMillanModel.setGoalTimeHours("1");
        mcMillanModel.setGoalTimeMinutes("05");
        mcMillanModel.setGoalTimeSeconds("10");
        mcMillanModel.setRecentDistanceType("1500m");
        mcMillanModel.setGoalDistanceType("1500m");

    }

    private void initTinmanModel() {
        tinmanModel = new TinmanModel();
        tinmanModel.setTimeHours("1");
        tinmanModel.setTimeMinutes("30");
        tinmanModel.setTimeSeconds("00");
        tinmanModel.setRaceDistance("0.4");
        tinmanModel.setGender("Female");
    }

    private void initHansonsModel() {
        hansonsModel = new HansonsModel();
        hansonsModel.setTimeHours("5");
        hansonsModel.setTimeMinutes("30");
        hansonsModel.setTimeSeconds("00");
        hansonsModel.setTemperature("15");
        hansonsModel.setWindSpeed("10");
        hansonsModel.setHumidity("80");
        hansonsModel.setRaceDistance("Marathon");
        hansonsModel.setTemperatureType("°C");
        hansonsModel.setSpeedType("mph");
    }

    private void initIntensityModel() {
        intensityModel = new IntensityModel();
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

