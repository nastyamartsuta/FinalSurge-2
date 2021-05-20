package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DeleteWorkoutPage;


public class DeleteWorkoutSteps extends AbstractCalendarPageSteps {

    public DeleteWorkoutSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public DeleteWorkoutSteps openDeletePage() {
        deleteWorkoutPage = new DeleteWorkoutPage(driver);
        openCalendarPage();
        deleteWorkoutPage.openPage();
        validateComponentIsLoaded(deleteWorkoutPage);
        return this;
    }

    @Step
    public DeleteWorkoutSteps deleteWorkoutPage() {
        deleteWorkoutPage.clickDeleteButton();
        return this;
    }

    @Step
    public void checkingWorkoutDeleted() {
        Assert.assertTrue(deleteWorkoutPage.checkingWorkoutDeleted(), "Workout not deleted");
    }
}
