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
    public AddWorkoutSteps fillNewWorkout(SwimWorkoutModel swimWorkoutModel) {
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

    @Step("Save a new workout")
    public AddWorkoutSteps saveNewWorkout() {
        workoutsPage.clickAddWorkoutsButton();
        return this;
    }

    @Step("Checking that the new workout was added")
    public void checkingNewWorkoutWasAdded(SwimWorkoutModel swimWorkoutModel) {
        Assert.assertTrue(workoutsPage.chekWorkoutDetailsIsOpen(), "Workout Details is not open");
        Assert.assertEquals(workoutsPage.getActualTimeOfDay(), swimWorkoutModel.getWorkoutTime(), "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualWorkoutName(), swimWorkoutModel.getWorkoutName(), "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualWorkoutDescription(), swimWorkoutModel.getWorkoutDescription(), "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualDistance(), swimWorkoutModel.getDistance(), "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualDistanceType(), swimWorkoutModel.getDistanceType(), "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualDuration(), swimWorkoutModel.getDuration(), "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualPerceivedEffort(), swimWorkoutModel.getPerceivedEffort(), "Incorrect text");
        Assert.assertEquals(workoutsPage.getActualCalories(), swimWorkoutModel.getCaloriesBurned(), "Incorrect text");
    }
}

