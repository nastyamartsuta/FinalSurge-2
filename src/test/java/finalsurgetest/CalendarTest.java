package finalsurgetest;

import io.qameta.allure.Description;
import model.CommentModel;
import model.UploadWorkoutDataModel;
import model.WorkoutQuickModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static pages.MoveWorkoutPage.*;

public class CalendarTest extends WithLoginTest {

    WorkoutQuickModel workoutQuickModel;
    UploadWorkoutDataModel uploadWorkoutDataModel;
    CommentModel commentModel;

    @Test
    @Description(value = "Delete workout test")
    public void deleteUploadedWorkoutTest() {
        initUploadWorkoutData();
        uploadWorkoutDataSteps
                .openUploadPage()
                .fillUploadWorkoutData(uploadWorkoutDataModel)
                .uploadFile()
                .checkingFileWasUploaded(uploadWorkoutDataModel);
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .deleteWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .checkingWorkoutWasDeleted();
    }

    @Test
    @Description(value = "Add workout quick test")
    public void addWorkoutQuickTest() {
        initWorkoutQuick();
        addWorkoutQuickSteps
                .openNewWorkoutQuickPage()
                .fillNewWorkoutQuickPage(workoutQuickModel)
                .saveNewQuickWorkout()
                .checkingNewWorkoutQuickWasAdded(workoutQuickModel);
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .deleteWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
    }

    @Test
    @Description(value = "Move workout test")
    public void moveWorkoutTest() {
        initWorkoutQuick();
        addWorkoutQuickSteps
                .openNewWorkoutQuickPage()
                .fillNewWorkoutQuickPage(workoutQuickModel)
                .saveNewQuickWorkout()
                .checkingNewWorkoutQuickWasAdded(workoutQuickModel);
        moveWorkoutSteps
                .openMoveMenu()
                .moveWorkout()
                .checkingWorkoutsWasMoved();
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, MOVE_DAY_PATTERN, MOVE_MONTH_PATTERN, MOVE_YEAR_PATTERN)
                .deleteWorkout(MOVE_DAY_PATTERN, MOVE_MONTH_PATTERN, MOVE_YEAR_PATTERN);
    }

    @Test
    @Description(value = "Add new comment test")
    public void addCommentTest() {
        initWorkoutQuick();
        initNewComment();
        addWorkoutQuickSteps
                .openNewWorkoutQuickPage()
                .fillNewWorkoutQuickPage(workoutQuickModel)
                .saveNewQuickWorkout()
                .checkingNewWorkoutQuickWasAdded(workoutQuickModel);
        commentsStep
                .openNewCommentPage()
                .sendComment(commentModel)
                .saveNewComment()
                .checkingNewCommentWasAdded(commentModel)
                .deleteNewComment()
                .closeCommentPage();
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .deleteWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
    }

    @Test
    @Description(value = "Open workout library test")
    public void openLibraryTest() {
        openWorkoutLibrarySteps
                .openWorkoutsLibraryPanel()
                .selectActivityTypeFilter()
                .checkingLibraryWasOpened();
    }


    @Test
    @Description(value = "View workout details test")
    public void viewWorkoutDetailsTest() throws InterruptedException {
        initUploadWorkoutData();
        uploadWorkoutDataSteps
                .openUploadPage()
                .fillUploadWorkoutData(uploadWorkoutDataModel)
                .uploadFile()
                .checkingFileWasUploaded(uploadWorkoutDataModel);
        viewWorkoutDetailsStep
                .openWorkoutsDetailsPage()
                .checkingWorkoutsDetailsPageWasOpened();
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .deleteWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
    }

    @Test
    @Description(value = "Upload workout data test")
    public void uploadWorkoutDataTest() throws InterruptedException {
        initUploadWorkoutData();
        uploadWorkoutDataSteps
                .openUploadPage()
                .fillUploadWorkoutData(uploadWorkoutDataModel)
                .uploadFile()
                .checkingFileWasUploaded(uploadWorkoutDataModel);
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .deleteWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
    }

    private void initUploadWorkoutData() {
        uploadWorkoutDataModel = new UploadWorkoutDataModel();
        uploadWorkoutDataModel.setWorkoutDateAdd(MONTH_PATTERN + "/" + DAY_PATTERN + "/" + YEAR_PATTERN);
        uploadWorkoutDataModel.setDescription("Walking bike");
        uploadWorkoutDataModel.setName("Bike");
        uploadWorkoutDataModel.setActivityType("Bike");
    }


    private void initWorkoutQuick() {
        workoutQuickModel = new WorkoutQuickModel();
        workoutQuickModel.setName("Run/swim");
        workoutQuickModel.setWorkoutDate("5/30/2021");
        workoutQuickModel.setDistance("5");
        workoutQuickModel.setDuration("0:50");
        workoutQuickModel.setPace("12000");
        workoutQuickModel.setWorkoutDescription("Warm-up, run, stretching");
        workoutQuickModel.setResults("Check pulse and blood pressure");
        workoutQuickModel.setDistanceType("km");
        workoutQuickModel.setPaceType("km");
        workoutQuickModel.setHowFeel("2");
        workoutQuickModel.setPerceivedEffort("3");
        workoutQuickModel.setActivityType("Run");
        workoutQuickModel.setTimeOfDay("12:45 AM");
    }

    private void initNewComment() {
        commentModel = new CommentModel();
        commentModel.setWorkoutComment("Test comment");
    }

    @AfterMethod
    @Override
    public void tearDown() {
        driver.switchTo().defaultContent();
        super.tearDown();
    }
}