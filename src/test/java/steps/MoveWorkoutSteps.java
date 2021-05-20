package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.MoveWorkoutPage;

public class MoveWorkoutSteps extends AbstractCalendarPageSteps {

    private String newDay;

    public MoveWorkoutSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public MoveWorkoutSteps openMoveMenu() {
        moveWorkoutPage = new MoveWorkoutPage(driver);
        openCalendarPage();
        moveWorkoutPage.openPage();
        return this;
    }

    @Step
    public MoveWorkoutSteps moveWorkout() {
        newDay = moveWorkoutPage.selectNewWorkoutDay();
        return this;
    }

    @Step
    public void checkingWorkoutsWasMoved() {
        Assert.assertTrue(moveWorkoutPage.checkingCommentAdded(MoveWorkoutPage.MONTH_PATTERN,
                newDay, MoveWorkoutPage.YEAR_PATTERN),
                "Workout wasn't moved");
    }
}



