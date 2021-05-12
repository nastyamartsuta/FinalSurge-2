package steps;

import elements.*;
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

    @Step
    public AddWorkoutSteps openAddWorkoutPanel() {
        workoutsPage.openPage();
        validateComponentIsLoaded(workoutsPage);
        workoutsPage.openAddNewWorkoutSwim();
        return this;
    }

    @Step
    public AddWorkoutSteps fillNewWorkoutSwim(SwimWorkoutModel swimWorkoutModel) {
        new Input(driver, "WorkoutDate").clear();
        new Input(driver, "WorkoutDate").enterInput(swimWorkoutModel.getDate());
        new Input(driver, "WorkoutTime").enterInput(swimWorkoutModel.getWorkoutTime());
        new Input(driver, "Name").enterInput(swimWorkoutModel.getWorkoutName());
        new Input(driver, "Distance").enterInput(swimWorkoutModel.getDistance());
        new Input(driver, "Duration").enterInput(swimWorkoutModel.getDuration());
        new Input(driver, "Pace").enterInput(swimWorkoutModel.getPace());
        new Input(driver, "kCal").enterInput(swimWorkoutModel.getCaloriesBurned());
        new DropdownSelectByVisibleText(driver, "DistType").select(swimWorkoutModel.getDistanceType());
        new DropdownSelectByVisibleText(driver, "PaceType").select(swimWorkoutModel.getPaceType());
        new DropdownSelectByVisibleText(driver, "PerEffort").select(swimWorkoutModel.getPerceivedEffort());
        new Textarea(driver, "Workout Description").enterTextarea(swimWorkoutModel.getWorkoutDescription());
        new RadioButton(driver, "Good").selectRadioButton();
        return this;
    }

    @Step
    public AddWorkoutSteps saveNewWorkout() {
        workoutsPage.clickAddWorkoutsButton();
        return this;
    }

    @Step
    public void checkingNewWorkoutAdd(SwimWorkoutModel swimWorkoutModel) {
        Assert.assertTrue(workoutsPage.chekWorkoutDetailsIsOpen(), "Workout Details is not open");
        Assert.assertTrue(workoutsPage.getActualText().contains(
                "Thursday, May 13, 2021 - " + swimWorkoutModel.getWorkoutTime() + "\n"
                        + "Swim" + "\n" +
                        swimWorkoutModel.getWorkoutName() + "\n" +
                        "Workout Description:" + "\n" +
                        swimWorkoutModel.getWorkoutDescription() + "\n" +
                        "Workout Statistics:" + "\n" +
                        swimWorkoutModel.getDistance() + " " + swimWorkoutModel.getDistanceType()
                        + " ~ " + swimWorkoutModel.getDuration() + " " + swimWorkoutModel.getPace() + " "
                        + swimWorkoutModel.getPaceType() + "\n" +
                        "How I Felt: Good   Perceived Effort " + swimWorkoutModel.getPerceivedEffort() + "\n" +
                        "Calories Burned: " + swimWorkoutModel.getCaloriesBurned() + " kCal" + "\n" +
                        "+Share"
                ),
                "Incorrect text");
    }
}

