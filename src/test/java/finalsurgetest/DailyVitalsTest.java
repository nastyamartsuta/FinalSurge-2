package finalsurgetest;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class DailyVitalsTest extends WithLoginTest {

    @Test
    @Description(value = "View vitals test")
    public void viewVitalsTest() {
        viewVitalsSteps
                .openViewPage()
                .viewLastMonthDailyVitals()
                .checkingLastMonthDailyVitalsWasViewed();
    }

    @Test
    @Description(value = "Add vitals test")
    public void addVitalsTest() {
        addVitalsSteps
                .openAddDailyVitals()
                .fillNewDailyVitals()
                .saveNewDailyVitals()
                .showThisYear()
                .checkingNewDailyVitalsWasAdded();
    }
}
