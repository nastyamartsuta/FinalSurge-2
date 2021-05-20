package steps;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import model.HansonsModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HansonsSteps extends AbstractWorkoutCalculatorSteps {

    public HansonsSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public HansonsSteps openHansons() {
        openCalculatorPage();
        hansonsPage.openPage();
        return this;
    }

    @Step
    public HansonsSteps fillHansons(HansonsModel hansonsModel) {
        new Input(driver, "TimeHH").enterInput(hansonsModel.getTimeHours());
        new Input(driver, "TimeMM").enterInput(hansonsModel.getTimeMinutes());
        new Input(driver, "TimeSS").enterInput(hansonsModel.getTimeSeconds());
        new Input(driver, "Temp").enterInput(hansonsModel.getTemperature());
        new Input(driver, "Wind").enterInput(hansonsModel.getWindSpeed());
        new Input(driver, "Humid").enterInput(hansonsModel.getHumidity());
        new Dropdown(driver, "RaceDist").select(hansonsModel.getRaceDistance());
        new Dropdown(driver, "TempType").select(hansonsModel.getTemperatureType());
        new Dropdown(driver, "SpeedType").select(hansonsModel.getSpeedType());
        return this;
    }

    @Step
    public HansonsSteps saveCalculatorPaces() {
        hansonsPage.clickCalculatePacesButton();
        return this;
    }

    @Step
    public void checkCalculation(HansonsModel hansonsModel) {
        Assert.assertTrue(hansonsPage.checkCalculationsIsOpened(), "Calculations did not open");
        Assert.assertTrue(hansonsPage.text().contains("Temperature: " + hansonsModel.getTemperature() + " °"
                + hansonsModel.getTemperatureType() + ","), "Incorrect text");
        Assert.assertTrue(hansonsPage.text().contains("Humidity: " + hansonsModel.getHumidity() + "%,"), "Incorrect text");
        Assert.assertTrue(hansonsPage.text().contains("Wind Speed: " + hansonsModel.getWindSpeed() + " "
                + hansonsModel.getSpeedType()), "Incorrect text");
        Assert.assertTrue(hansonsPage.textInTable().contains(hansonsModel.getTimeHours() + ":" + hansonsModel.getTimeMinutes()
                + ":" + hansonsModel.getTimeSeconds()), "Incorrect text");
    }
}
