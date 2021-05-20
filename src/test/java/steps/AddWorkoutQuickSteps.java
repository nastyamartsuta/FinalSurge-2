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

    @Step
    public AddWorkoutQuickSteps openNewWorkoutQuickPage() {
        openCalendarPage();
        calendarPage.openQuickAddPanel();
        newWorkoutQuickPage = new NewWorkoutQuickPage(driver);
        validateComponentIsLoaded(newWorkoutQuickPage);
        return this;
    }

    @Step
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

    @Step
    public AddWorkoutQuickSteps saveNewWorkout() {
        newWorkoutQuickPage.saveNewWorkout();
        return this;
    }

    @Step
    public void checkingVitalsAdd(WorkoutQuickModel workoutQuickModel) {
        Assert.assertTrue(newWorkoutQuickPage.checkingWorkoutAdded(), "Workout was not added");
        Assert.assertTrue(newWorkoutQuickPage.getText().contains(
                workoutQuickModel.getTimeOfDay() + "\n" +
                        workoutQuickModel.getName() + ": " + workoutQuickModel.getActivityType() + "\n" +
                        workoutQuickModel.getDistance() + " " + workoutQuickModel.getDistanceType() +
                        " ~ " + workoutQuickModel.getDuration()),
                "Incorrect text");
    }
}
