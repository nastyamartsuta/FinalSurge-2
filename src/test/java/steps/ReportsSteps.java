package steps;

import elements.Dropdown;
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

    @Step
    public ReportsSteps openReportsPage() {
        reportsPage.openPage();
        validateComponentIsLoaded(reportsPage);
        return this;
    }

    @Step
    public ReportsSteps fillReports(ReportsModel reportsModel) {
        //input
        new Input(driver, "WorkoutDate").clear();
        new Input(driver, "WorkoutDate").enterInput(reportsModel.getStartDate());
        new Input(driver, "WorkoutDateEnd").clear();
        new Input(driver, "WorkoutDateEnd").enterInput(reportsModel.getEndDate());

        //radiobutton
        new RadioButton(driver, "List View").selectRadioButton();

        //dropdown
        new Dropdown(driver, "ActivityType").select(reportsModel.getActivityType());
        return this;
    }

    @Step
    public ReportsSteps viewReport() {
        reportsPage.viewReportButton();
        return this;
    }

    @Step
    public void checkReportsOpened() {
        //TODO на что тут еще можно написать assert?
        Assert.assertTrue(reportsPage.checkReportsOpened(), "Reports did not open");
    }
}