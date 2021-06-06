package steps;

import elements.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import model.WorkoutQuickModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.NewWorkoutQuickPage;

@Log4j2
public class AddWorkoutQuickSteps extends AbstractCalendarPageSteps {

    public AddWorkoutQuickSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open add new workout quick page")
    public AddWorkoutQuickSteps openNewWorkoutQuickPage() {
        openCalendarPage();
        calendarPage.openQuickAddPanel();
        newWorkoutQuickPage = new NewWorkoutQuickPage(driver);
        validateComponentIsLoaded(newWorkoutQuickPage);
        return this;
    }

    @Step("Fill in the fields to add a new workout quick")
    public AddWorkoutQuickSteps fillNewWorkoutQuickPage() {
        new InputNewWorkoutQuick(driver, "Name", "Name").enterInput(WorkoutQuickModel.name);
        new InputNewWorkoutQuick(driver, "WorkoutDate", "WorkoutDate").clear();
        new InputNewWorkoutQuick(driver, "WorkoutDate", "WorkoutDate").enterInput(WorkoutQuickModel.workoutDate);
        new InputNewWorkoutQuick(driver, "Distance", "Distance").enterInput(WorkoutQuickModel.distance);
        new InputNewWorkoutQuick(driver, "Duration", "Duration").enterInput(WorkoutQuickModel.duration);
        new InputNewWorkoutQuick(driver, "Pace", "Pace").clear();
        new InputNewWorkoutQuick(driver, "Pace", "Pace").enterInput(WorkoutQuickModel.pace);
        new Textarea(driver, "Workout Description").enterTextarea(WorkoutQuickModel.workoutDescription);
        new Textarea(driver, "Post Workout Notes/Results").enterTextarea(WorkoutQuickModel.results);
        new Dropdown(driver, "DistType").select(WorkoutQuickModel.distanceType);
        new Dropdown(driver, "PaceType").select(WorkoutQuickModel.paceType);
        new Dropdown(driver, "HowFeel").select(WorkoutQuickModel.howFeel);
        new Dropdown(driver, "PerEffort").select(WorkoutQuickModel.perceivedEffort);
        new DropdownSelectByVisibleText(driver, "ActivityType").select(WorkoutQuickModel.activityType);
        new Autocomplete(driver, "WorkoutTime").enterAutocomplete(WorkoutQuickModel.timeOfDay);
        new Checkbox(driver, "SaveLibrary").selectCheckbox();
        return this;
    }

    @Step("Save new quick workout")
    public AddWorkoutQuickSteps saveNewQuickWorkout() {
        newWorkoutQuickPage.saveNewWorkout();
        return this;
    }

    @Step("Checking that the new quick workout was added")
    public void checkingNewWorkoutQuickWasAdded() {
        Assert.assertTrue(newWorkoutQuickPage.checkingWorkoutAdded(), "Workout was not added");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutTime(), WorkoutQuickModel.timeOfDay, "Incorrect text");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutType(), WorkoutQuickModel.activityType, "Incorrect text");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutName(), WorkoutQuickModel.name, "Incorrect text");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutDistance(), WorkoutQuickModel.distance, "Incorrect text");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutDistanceType(), WorkoutQuickModel.distanceType, "Incorrect text");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutDuration(), WorkoutQuickModel.duration, "Incorrect text");
    }
}
