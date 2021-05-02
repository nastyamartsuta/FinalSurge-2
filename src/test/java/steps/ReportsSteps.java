package steps;

import elements.Dropdown;
import elements.InputHansons;
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
        new InputHansons(driver, "WorkoutDate").clear();
        new InputHansons(driver, "WorkoutDate").enterInputHansons(reportsModel.getStartDate());
        new InputHansons(driver, "WorkoutDateEnd").clear();
        new InputHansons(driver, "WorkoutDateEnd").enterInputHansons(reportsModel.getEndDate());

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
        //TODO на что тут еще можно написать assert
        Assert.assertTrue(reportsPage.checkReportsOpened(), "Reports did not open");
    }
}