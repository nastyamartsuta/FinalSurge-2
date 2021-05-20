package finalsurgetest;

import io.qameta.allure.Description;
import model.ReportsModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportsTest extends BaseTest {

    ReportsModel reportsModel = new ReportsModel();

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        initReportsModel();
    }

    @Test
    @Description(value = "Reports test")
    public void reportsTest() {
        loginSteps
                .openLoginPage()
                .authentication();
        reportsSteps
                .openReportsPage()
                .fillReports(reportsModel)
                .viewReport()
                .checkReportsOpened();

    }

    private void initReportsModel() {
        reportsModel = new ReportsModel();
        reportsModel.setStartDate("01/01/2021");
        reportsModel.setEndDate("12/12/2021");
        reportsModel.setActivityType("Run");
    }
}
