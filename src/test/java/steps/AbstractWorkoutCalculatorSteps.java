package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public abstract class AbstractWorkoutCalculatorSteps extends AbstractStep {

    HansonsPage hansonsPage = new HansonsPage(driver);
    IntensityPage intensityPage = new IntensityPage(driver);
    McMillanPage mcMillanPage = new McMillanPage(driver);
    TinmanPage tinmanPage = new TinmanPage(driver);

    public AbstractWorkoutCalculatorSteps(WebDriver driver) {
        super(driver);
    }

    public void openCalculatorPage() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.openPage();
        validateComponentIsLoaded(calculatorPage);
    }
}