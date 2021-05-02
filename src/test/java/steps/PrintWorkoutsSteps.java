package steps;

;
import elements.InputHansons;
import io.qameta.allure.Step;
import model.PrintWorkoutsModel;
import org.openqa.selenium.WebDriver;
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
        new InputHansons(driver, "WorkoutDate").enterInputHansons(printWorkoutsModel.getPrintEndingDate());
        new InputHansons(driver, "WorkoutDateEnd").enterInputHansons(printWorkoutsModel.getPrintStartingDate());

        return this;
    }

    @Step
    public PrintWorkoutsSteps printWorkout() {
        printWorkoutsPage.clickPrintWorkoutsButton();
        return this;
    }

    @Step
    public void checkingResultIsPrinted() {
        //TODO как сделать assert если открывается нова страница
       // Assert.assertTrue(reportsPage.checkReportsOpened(), "Reports did not open");
    }
}