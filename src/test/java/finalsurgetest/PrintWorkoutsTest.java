package finalsurgetest;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PrintWorkoutsTest extends WithLoginTest {

    @Test
    @Description(value = "Print workout test")
    public void printWorkoutTest() {
        printWorkoutsSteps
                .openPrintPage()
                .fillPrintWorkout()
                .printWorkout()
                .switchToPrintTab()
                .checkingResultWasPrinted();
    }

    @AfterMethod
    @Override
    public void tearDown() {
        driver.switchTo().defaultContent();
        super.tearDown();
    }
}