package steps;

import elements.Dropdown;
import elements.InputHansons;
import io.qameta.allure.Step;
import model.HansonsModel;
import org.openqa.selenium.WebDriver;
import pages.CalculatorPage;
import pages.HansonsPage;


//TODO подумать как правильно переименовать степы
public class CalculatorSteps extends AbstractStep {

    HansonsPage hansonsPage = new HansonsPage(driver);

    public CalculatorSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public CalculatorSteps openCalculatorPage() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.openPage();
        validateComponentIsLoaded(calculatorPage);
        return this;
    }

    @Step
    public CalculatorSteps openHansons() {
        hansonsPage.openPage();
        return this;
    }

    @Step
    public CalculatorSteps fillHansons(HansonsModel hansonsModel) {
        //input
        new InputHansons(driver, "TimeHH").enterInputHansons(hansonsModel.getTimeHours());
        new InputHansons(driver, "TimeMM").enterInputHansons(hansonsModel.getTimeMinutes());
        new InputHansons(driver, "TimeSS").enterInputHansons(hansonsModel.getTimeSeconds());
        new InputHansons(driver, "Temp").enterInputHansons(hansonsModel.getTemperature());
        new InputHansons(driver, "Wind").enterInputHansons(hansonsModel.getWindSpeed());
        new InputHansons(driver, "Humid").enterInputHansons(hansonsModel.getHumidity());

        //dropdown
        new Dropdown(driver, "RaceDist").select(hansonsModel.getRaceDistance());
        new Dropdown(driver, "TempType").select(hansonsModel.getTemperatureType());
        new Dropdown(driver, "SpeedType").select(hansonsModel.getSpeedType());

        //TODO написать assert-ыЫы
        return this;
    }

    @Step
    public CalculatorSteps saveCalculatorPaces() {
        hansonsPage.clickCalculatePacesButton();
        return this;
    }

}
