package steps;

import elements.DropdownSelectByVisibleText;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import model.ReportsModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ReportsPage;

public class ReportsSteps extends AbstractStep {

    ReportsPage reportsPage = new ReportsPage(driver);

    public ReportsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open reports page")
    public ReportsSteps openReportsPage() {
        reportsPage.openPage();
        validateComponentIsLoaded(reportsPage);
        return this;
    }

    @Step("Fill in the reports fields")
    public ReportsSteps fillReports() {
        new Input(driver, "WorkoutDate").clear();
        new Input(driver, "WorkoutDate").enterInput(ReportsModel.startDate);
        new Input(driver, "WorkoutDateEnd").clear();
        new Input(driver, "WorkoutDateEnd").enterInput(ReportsModel.endDate);
        new RadioButton(driver, "List View").selectRadioButton();
        new DropdownSelectByVisibleText(driver, "ActivityType").select(ReportsModel.activityType);
        return this;
    }

    @Step("View report")
    public ReportsSteps viewReport() {
        reportsPage.viewReportButton();
        return this;
    }

    @Step("Checking reports was opened")
    public void checkingReportsWasOpened() {
        Assert.assertTrue(reportsPage.checkReportsOpened(), "Reports did not open");
    }
}