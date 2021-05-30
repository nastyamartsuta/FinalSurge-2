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
    public AddWorkoutQuickSteps fillNewWorkoutQuickPage(WorkoutQuickModel workoutQuickModel) {
        new InputNewWorkoutQuick(driver, "Name", "Name").enterInput(workoutQuickModel.getName());
        new InputNewWorkoutQuick(driver, "WorkoutDate", "WorkoutDate").clear();
        new InputNewWorkoutQuick(driver, "WorkoutDate", "WorkoutDate").enterInput(workoutQuickModel.getWorkoutDate());
        new InputNewWorkoutQuick(driver, "Distance", "Distance").enterInput(workoutQuickModel.getDistance());
        new InputNewWorkoutQuick(driver, "Duration", "Duration").enterInput(workoutQuickModel.getDuration());
        new InputNewWorkoutQuick(driver, "Pace", "Pace").clear();
        new InputNewWorkoutQuick(driver, "Pace", "Pace").enterInput(workoutQuickModel.getPace());
        new Textarea(driver, "Workout Description").enterTextarea(workoutQuickModel.getWorkoutDescription());
        new Textarea(driver, "Post Workout Notes/Results").enterTextarea(workoutQuickModel.getResults());
        new Dropdown(driver, "DistType").select(workoutQuickModel.getDistanceType());
        new Dropdown(driver, "PaceType").select(workoutQuickModel.getPaceType());
        new Dropdown(driver, "HowFeel").select(workoutQuickModel.getHowFeel());
        new Dropdown(driver, "PerEffort").select(workoutQuickModel.getPerceivedEffort());
        new DropdownSelectByVisibleText(driver, "ActivityType").select(workoutQuickModel.getActivityType());
        new Autocomplete(driver, "WorkoutTime").enterAutocomplete(workoutQuickModel.getTimeOfDay());
        new Checkbox(driver, "SaveLibrary").selectCheckbox();
        return this;
    }

    @Step("Save new quick workout")
    public AddWorkoutQuickSteps saveNewQuickWorkout() {
        newWorkoutQuickPage.saveNewWorkout();
        return this;
    }

    @Step("Checking that the new quick workout was added")
    public void checkingNewWorkoutQuickWasAdded(WorkoutQuickModel workoutQuickModel) {
        Assert.assertTrue(newWorkoutQuickPage.checkingWorkoutAdded(), "Workout was not added");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutTime(), workoutQuickModel.getTimeOfDay(), "Incorrect text");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutType(), workoutQuickModel.getActivityType(), "Incorrect text");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutName(), workoutQuickModel.getName(), "Incorrect text");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutDistance(), workoutQuickModel.getDistance(), "Incorrect text");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutDistanceType(), workoutQuickModel.getDistanceType(), "Incorrect text");
        Assert.assertEquals(newWorkoutQuickPage.getActualQuickWorkoutDuration(), workoutQuickModel.getDuration(), "Incorrect text");
    }
}
