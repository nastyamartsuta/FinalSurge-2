package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DeleteWorkoutPage;

public class DeleteWorkoutSteps extends AbstractCalendarPageSteps {

    public DeleteWorkoutSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open delete page")
    public DeleteWorkoutSteps openDeletePage(String locator, String day, String month, String year) {
        deleteWorkoutPage = new DeleteWorkoutPage(driver);
        openCalendarPage();
        calendarPage.openMenu(locator, day, month, year);
        return this;
    }

    @Step("Delete workout")
    public DeleteWorkoutSteps deleteWorkout(String day, String month, String year) {
        deleteWorkoutPage.findDeleteWorkoutButton(day, month, year);
        validateComponentIsLoaded(deleteWorkoutPage);
        deleteWorkoutPage.clickDeleteButton();
        return this;
    }

    @Step("Checking workouts was deleted")
    public void checkingWorkoutWasDeleted() {
        Assert.assertTrue(deleteWorkoutPage.checkingWorkoutDeleted(), "Workout not deleted");
    }
}
