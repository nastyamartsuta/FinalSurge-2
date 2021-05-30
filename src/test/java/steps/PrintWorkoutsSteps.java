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

    @Step("Open print page")
    public PrintWorkoutsSteps openPrintPage() {
        printWorkoutsPage.openPage();
        validateComponentIsLoaded(printWorkoutsPage);
        return this;
    }

    @Step("Fill in the print workout fields")
    public PrintWorkoutsSteps fillPrintWorkout(PrintWorkoutsModel printWorkoutsModel) {
        new Input(driver, "PrintStartDate").enterInput(printWorkoutsModel.getPrintStartingDate());
        new Input(driver, "PrintEndDate").enterInput(printWorkoutsModel.getPrintEndingDate());
        return this;
    }

    @Step("Print workouts")
    public PrintWorkoutsSteps printWorkout() {
        printWorkoutsPage.clickPrintWorkoutsButton();
        return this;
    }

    @Step("Checking result was printed")
    public void checkingResultWasPrinted() {
        PrintPage printPage = new PrintPage(driver);
        validateComponentIsLoaded(printPage);
    }

    @Step("Switch to print tab")
    public PrintWorkoutsSteps switchToPrintTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
}