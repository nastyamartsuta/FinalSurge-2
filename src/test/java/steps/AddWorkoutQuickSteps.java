package steps;

import elements.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import model.WorkoutQuickModel;
import org.openqa.selenium.WebDriver;


@Log4j2
public class AddWorkoutQuickSteps extends AbstractCalendarPageSteps {

    public AddWorkoutQuickSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public AddWorkoutQuickSteps openNewWorkoutQuickPage() {
        openCalendarPage();
        calendarPage.openQuickAddPanel();
        validateComponentIsLoaded(newWorkoutQuickPage);
        return this;
    }

    @Step
    public AddWorkoutQuickSteps fillNewWorkoutQuickPage(WorkoutQuickModel workoutQuickModel) {
        //input
        new InputNewWorkoutQuick(driver, "Name", "Name").enterInput(workoutQuickModel.getName());
        new InputNewWorkoutQuick(driver, "WorkoutDate", "WorkoutDate").clear();
        new InputNewWorkoutQuick(driver, "WorkoutDate", "WorkoutDate").enterInput(workoutQuickModel.getWorkoutDate());
        new InputNewWorkoutQuick(driver, "Distance", "Distance").enterInput(workoutQuickModel.getDistance());
        new InputNewWorkoutQuick(driver, "Duration", "Duration").enterInput(workoutQuickModel.getDuration());
        new InputNewWorkoutQuick(driver, "Pace", "Pace").clear();
        new InputNewWorkoutQuick(driver, "Pace", "Pace").enterInput(workoutQuickModel.getPace());
        //textarea
        new Textarea(driver, "Workout Description").enterTextarea(workoutQuickModel.getWorkoutDescription());
        new Textarea(driver, "Post Workout Notes/Results").enterTextarea(workoutQuickModel.getResults());

        //dropdown
        new Dropdown(driver, "DistType").select(workoutQuickModel.getDistanceType());
        new Dropdown(driver, "PaceType").select(workoutQuickModel.getPaceType());
        new Dropdown(driver, "HowFeel").select(workoutQuickModel.getHowFeel());
        new Dropdown(driver, "PerEffort").select(workoutQuickModel.getPerceivedEffort());
        new DropdownSelectByVisibleText(driver, "ActivityType").select(workoutQuickModel.getActivityType());

        //autocomplete
        new Autocomplete(driver, "WorkoutTime").enterAutocomplete(workoutQuickModel.getTimeOfDay());

        //checkbox
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

        //TODO написать assert-ыЫы как написать что в нужный день добавилась тренировка

    }

}
