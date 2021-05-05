package steps;

import elements.Input;
import io.qameta.allure.Step;
import model.PrintWorkoutsModel;
import org.openqa.selenium.WebDriver;
import pages.PrintPage;
import pages.PrintWorkoutsPage;

public class PrintWorkoutsSteps extends AbstractStep {

    PrintWorkoutsPage printWorkoutsPage = new PrintWorkoutsPage(driver);

    public PrintWorkoutsSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public PrintWorkoutsSteps openReportsPage() {
        printWorkoutsPage.openPage();
        validateComponentIsLoaded(printWorkoutsPage);
        return this;
    }

    @Step
    public PrintWorkoutsSteps fillPrintWorkout(PrintWorkoutsModel printWorkoutsModel) {
        //input
        new Input(driver, "WorkoutDate").enterInput(printWorkoutsModel.getPrintEndingDate());
        new Input(driver, "WorkoutDateEnd").enterInput(printWorkoutsModel.getPrintStartingDate());
        return this;
    }

    @Step
    public PrintWorkoutsSteps printWorkout() {
        printWorkoutsPage.clickPrintWorkoutsButton();
        return this;
    }

    @Step
    public void checkingResultIsPrinted() {
        PrintPage printPage = new PrintPage(driver);
        validateComponentIsLoaded(printPage);
    }
}