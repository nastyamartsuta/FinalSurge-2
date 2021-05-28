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
        new DropdownSelectByVisibleText(driver, "TempType").select(hansonsModel.getTemperatureType());
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
        Assert.assertEquals(hansonsPage.getActualTemperature(), hansonsModel.getTemperature(), "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualTemperatureType(), hansonsModel.getTemperatureType(), "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualHumidity(), hansonsModel.getHumidity(), "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualWindySpeed(), hansonsModel.getWindSpeed(), "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualDistance(), hansonsModel.getRaceDistance(), "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualHours(), hansonsModel.getTimeHours(), "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualMinutes(), hansonsModel.getTimeMinutes(), "Incorrect text");
        Assert.assertEquals(hansonsPage.getActualSeconds(), hansonsModel.getTimeSeconds(), "Incorrect text");
    }
}
