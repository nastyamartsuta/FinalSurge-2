package finalsurgetest;

import io.qameta.allure.Description;
import model.PrintWorkoutsModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrintWorkoutsTest extends WithLoginTest {

    PrintWorkoutsModel printWorkoutsModel = new PrintWorkoutsModel();

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        initPrintWorkoutModel();
    }

    @Test
    @Description(value = "Print workout test")
    public void printWorkoutTest() {
        printWorkoutsSteps.openReportsPage()
                .fillPrintWorkout(printWorkoutsModel)
                .printWorkout()
                .switchToPrintTab()
                .checkingResultIsPrinted();
    }

    private void initPrintWorkoutModel() {
        printWorkoutsModel = new PrintWorkoutsModel();
        printWorkoutsModel.setPrintStartingDate("1/1/2021");
        printWorkoutsModel.setPrintEndingDate("12/12/2021");
    }
}