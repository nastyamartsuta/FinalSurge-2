package steps;

import elements.Input;
import io.qameta.allure.Step;
import model.PrintWorkoutsModel;
import org.openqa.selenium.WebDriver;
import pages.PrintPage;
import pages.PrintWorkoutsPage;

import java.util.ArrayList;

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
        new Input(driver, "PrintStartDate").enterInput(printWorkoutsModel.getPrintStartingDate());
        new Input(driver, "PrintEndDate").enterInput(printWorkoutsModel.getPrintEndingDate());
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

    @Step
    public PrintWorkoutsSteps switchToPrintTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return this;
    }
}