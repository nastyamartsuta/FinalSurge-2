package steps;

import elements.DropdownSelectByVisibleText;
import elements.Input;
import elements.RadioButton;
import elements.Textarea;
import io.qameta.allure.Step;
import model.SwimWorkoutModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.WorkoutsPage;

public class AddWorkoutSteps extends AbstractStep {

    WorkoutsPage workoutsPage = new WorkoutsPage(driver);

    public AddWorkoutSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open add a new workout panel ")
    public AddWorkoutSteps openAddWorkoutPanel() {
        workoutsPage.openPage();
        validateComponentIsLoaded(workoutsPage);
        workoutsPage.openAddNewWorkoutSwim();
        return this;
    }

    @Step("Fill in the fields to add a new workout")
    public AddWorkoutSteps fillNewWorkout() {
        new Input(driver, "WorkoutDate").clear();
        new Input(driver, "WorkoutDate").enterInput(SwimWorkoutModel.date);
        new Input(driver, "WorkoutTime").enterInput(SwimWorkoutModel.workoutTime);
        new Input(driver, "Name").enterInput(SwimWorkoutModel.workoutName);
        new Input(driver, "Distance").enterInput(SwimWorkoutModel.distance);
        new Input(driver, "Duration").enterInput(SwimWorkoutModel.duration);
        new Input(driver, "Pace").enterInput(SwimWorkoutModel.pace);
        new Input(driver, "kCal").enterInput(SwimWorkoutModel.caloriesBurned);
        new DropdownSelectByVisibleText(driver, "DistType").select(SwimWorkoutModel.distanceType);
        new DropdownSelectByVisibleText(driver, "PaceType").select(SwimWorkoutModel.paceType);
        new DropdownSelectByVisibleText(driver, "PerEffort").select(SwimWorkoutModel.perceivedEffort);
        new Textarea(driver, "Workout Description").enterTextarea(SwimWorkoutModel.workoutDescription);
        new RadioButton(driver, "Good").selectRadioButton();
        return this;
    }

    @Step("Save a new workout")
    public AddWorkoutSteps saveNewWorkout() {
        workoutsPage.clickAddWorkoutsButton();
        return this;
    }

    @Step("Checking that the new workout was added")
    public void checkingNewWorkoutWasAdded() {
        Assert.assertTrue(workoutsPage.chekWorkoutDetailsIsOpen(), "Workout Details is not open");
        Assert.assertEquals(workoutsPage.getActualTimeOfDay(), SwimWorkoutModel.workoutTime, "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualWorkoutName(), SwimWorkoutModel.workoutName, "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualWorkoutDescription(), SwimWorkoutModel.workoutDescription, "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualDistance(), SwimWorkoutModel.distance, "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualDistanceType(), SwimWorkoutModel.distanceType, "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualDuration(), SwimWorkoutModel.duration, "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualPerceivedEffort(), SwimWorkoutModel.perceivedEffort, "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualCalories(), SwimWorkoutModel.caloriesBurned, "Incorrect text");
    }
}

