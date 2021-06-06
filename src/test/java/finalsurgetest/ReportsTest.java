package finalsurgetest;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ReportsTest extends WithLoginTest {

    @Test
    @Description(value = "Reports test")
    public void reportsTest() {
        reportsSteps
                .openReportsPage()
                .fillReports()
                .viewReport()
                .checkingReportsWasOpened();
    }
}
