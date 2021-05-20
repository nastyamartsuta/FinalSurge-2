package finalsurgetest;

import io.qameta.allure.Description;
import model.PrintWorkoutsModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrintWorkoutsTest extends BaseTest {

    PrintWorkoutsModel printWorkoutsModel = new PrintWorkoutsModel();

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        initPrintWorkoutModel();
    }

    @Test
    @Description(value = "Reports test")
    public void printWorkoutTest() {
        loginSteps
                .openLoginPage()
                .authentication();

        printWorkoutsSteps.openReportsPage()
                .fillPrintWorkout(printWorkoutsModel)
                .printWorkout()
                .checkingResultIsPrinted();
    }

    private void initPrintWorkoutModel() {
        printWorkoutsModel = new PrintWorkoutsModel();
        printWorkoutsModel.setPrintStartingDate("01/01/2021");
        printWorkoutsModel.setPrintEndingDate("12/12/2021");
    }
}