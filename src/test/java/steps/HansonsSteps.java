package steps;

import elements.Dropdown;
import elements.DropdownSelectByVisibleText;
import elements.Input;
import io.qameta.allure.Step;
import model.HansonsModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HansonsSteps extends AbstractWorkoutCalculatorSteps {

    public HansonsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open hansons page")
    public HansonsSteps openHansonsPage() {
        openCalculatorPage();
        hansonsPage.openPage();
        return this;
    }

    @Step("Fill in the Hansons fields")
    public HansonsSteps fillHansons() {
        new Input(driver, "TimeHH").enterInput(HansonsModel.timeHours);
        new Input(driver, "TimeMM").enterInput(HansonsModel.timeMinutes);
        new Input(driver, "TimeSS").enterInput(HansonsModel.timeSeconds);
        new Input(driver, "Temp").enterInput(HansonsModel.temperature);
        new Input(driver, "Wind").enterInput(HansonsModel.windSpeed);
        new Input(driver, "Humid").enterInput(HansonsModel.humidity);
        new Dropdown(driver, "RaceDist").select(HansonsModel.raceDistance);
        new DropdownSelectByVisibleText(driver, "TempType").select(HansonsModel.temperatureType);
        new Dropdown(driver, "SpeedType").select(HansonsModel.speedType);
        return this;
    }

    @Step("Calculate paces")
    public HansonsSteps calculatePaces() {
        hansonsPage.clickCalculatePacesButton();
        return this;
    }

    @Step("Checking hansons calculation was opened")
    public void checkingCalculationWasOpened() {
        Assert.assertTrue(hansonsPage.checkCalculationsIsOpened(), "Calculations did not open");
        Assert.assertEquals(hansonsPage.getActualTemperature(), HansonsModel.temperature, "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualTemperatureType(), HansonsModel.temperatureType, "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualHumidity(), HansonsModel.humidity, "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualWindySpeed(), HansonsModel.windSpeed, "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualDistance(), HansonsModel.raceDistance, "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualHours(), HansonsModel.timeHours, "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualMinutes(), HansonsModel.timeMinutes, "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualSeconds(), HansonsModel.timeSeconds, "Incorrect text");
    }
}
