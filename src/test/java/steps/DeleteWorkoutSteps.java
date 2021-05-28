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
    public DeleteWorkoutSteps openDeletePage(String locator, String day, String month, String year) {
        deleteWorkoutPage = new DeleteWorkoutPage(driver);
        openCalendarPage();
        calendarPage.openMenu(locator, day, month, year);
        return this;
    }

    @Step
    public DeleteWorkoutSteps deleteWorkoutPage(String day, String month, String year) {
        deleteWorkoutPage.findDeleteWorkoutButton(day, month, year);
        validateComponentIsLoaded(deleteWorkoutPage);
        deleteWorkoutPage.clickDeleteButton();
        return this;
    }

    @Step
    public void checkingWorkoutDeleted() {
        Assert.assertTrue(deleteWorkoutPage.checkingWorkoutDeleted(), "Workout not deleted");
    }
}
