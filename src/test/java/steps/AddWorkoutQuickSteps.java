package steps;

import elements.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import model.WorkoutQuickModel;
import org.openqa.selenium.WebDriver;
import pages.CalendarPage;
import pages.NewWorkoutQuickPage;

@Log4j2
public class AddWorkoutQuickSteps extends AbstractStep {

    protected CalendarPage calendarPage;
    protected NewWorkoutQuickPage newWorkoutQuickPage;

    public AddWorkoutQuickSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public AddWorkoutQuickSteps openCalendarPage() {
        calendarPage = new CalendarPage(driver);
        calendarPage.openPage();
        validateComponentIsLoaded(calendarPage);
        return this;
    }

    @Step
    public AddWorkoutQuickSteps openNewWorkoutQuickPage() {
        newWorkoutQuickPage = new NewWorkoutQuickPage(driver);
        calendarPage.createNewWorkout();
        validateComponentIsLoaded(newWorkoutQuickPage);
        return this;
    }

    @Step
    public AddWorkoutQuickSteps fillNewWorkoutQuickPage(WorkoutQuickModel workoutQuickModel) {
        //input
        new Input(driver, "Name", "Name").enterInput(workoutQuickModel.getName());
        new Input(driver, "WorkoutDate", "WorkoutDate").clear();
        new Input(driver, "WorkoutDate", "WorkoutDate").enterInput(workoutQuickModel.getWorkoutDate());
        new Input(driver, "Distance", "Distance").enterInput(workoutQuickModel.getDistance());
        new Input(driver, "Duration", "Duration").enterInput(workoutQuickModel.getDuration());
        new Input(driver, "Pace", "Pace").clear();
        new Input(driver, "Pace", "Pace").enterInput(workoutQuickModel.getPace());
        //textarea
        new Textarea(driver, "Workout Description").enterTextarea(workoutQuickModel.getWorkoutDescription());
        new Textarea(driver, "Post Workout Notes/Results").enterTextarea(workoutQuickModel.getResults());

        //dropdown
        new Dropdown(driver, "DistType").select(workoutQuickModel.getDistanceType());
        new Dropdown(driver, "PaceType").select(workoutQuickModel.getPaceType());
        new Dropdown(driver, "HowFeel").select(workoutQuickModel.getHowFeel());
        new Dropdown(driver, "PerEffort").select(workoutQuickModel.getPerceivedEffort());
        new Dropdown(driver, "ActivityType").select(workoutQuickModel.getActivityType());

        //autocomplete
        new Autocomplete(driver, "WorkoutTime").enterAutocomplete(workoutQuickModel.getTimeOfDay());

        //checkbox
        new Checkbox(driver, "SaveLibrary").selectCheckbox();

        //TODO написать assert-ыЫы
        return this;
    }

    @Step
    public AddWorkoutQuickSteps saveNewWorkout() {
        newWorkoutQuickPage.saveNewWorkout();
        return this;
    }


}
