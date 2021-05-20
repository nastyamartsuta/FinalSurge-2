package finalsurgetest;

import io.qameta.allure.Description;
import model.CommentModel;
import model.UploadWorkoutDataModel;
import model.WorkoutQuickModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static pages.UploadWorkoutDataPage.*;

public class CalendarTest extends BaseTest {


    //TODO дописать тесты на календарь

    WorkoutQuickModel workoutQuickModel;
    UploadWorkoutDataModel uploadWorkoutDataModel;
    CommentModel commentModel;

    @Test
    @Description(value = "Add workout quick test")
    public void addWorkoutQuickTest() {
        initWorkoutQuick();
        loginSteps
                .openLoginPage()
                .authentication();
        addWorkoutQuickSteps
                .openNewWorkoutQuickPage()
                .fillNewWorkoutQuickPage(workoutQuickModel)
                .saveNewWorkout()
                .checkingVitalsAdd(workoutQuickModel);
    }

    @Test
    @Description(value = "Move workout test")
    public void moveWorkoutTest() {
        initWorkoutQuick();
        loginSteps
                .openLoginPage()
                .authentication();
        addWorkoutQuickSteps
                .openNewWorkoutQuickPage()
                .fillNewWorkoutQuickPage(workoutQuickModel)
                .saveNewWorkout()
                .checkingVitalsAdd(workoutQuickModel);
        moveWorkoutSteps
                .openMoveMenu()
                .moveWorkout()
                .checkingWorkoutsWasMoved();
    }


    @Test
    @Description(value = "Add new comment test")
    public void addCommentTest() {
        initWorkoutQuick();
        initNewComment();
        loginSteps
                .openLoginPage()
                .authentication();
        addWorkoutQuickSteps
                .openNewWorkoutQuickPage()
                .fillNewWorkoutQuickPage(workoutQuickModel)
                .saveNewWorkout()
                .checkingVitalsAdd(workoutQuickModel);
        commentsStep
                .openNewCommentPage()
                .sendComment(commentModel)
                .saveNewComment()
                .checkingNewCommentWasAdded(commentModel)
                .deleteNewComment();
    }

    @Test
    @Description(value = "Open workout library test")
    public void openLibraryTest() {
        loginSteps
                .openLoginPage()
                .authentication();
        openWorkoutLibrarySteps
                .openWorkoutLibraryPanel()
                .selectActivityTypeFilter()
                .checkingLibraryIsOpen();
    }

    @Test
    @Description(value = " Delete workout test")
    public void deleteUploadWorkoutDataTest() {
        initUploadWorkoutData();
        loginSteps
                .openLoginPage()
                .authentication();
        uploadWorkoutDataSteps
                .openUploadPage()
                .fillUploadWorkoutData(uploadWorkoutDataModel)
                .saveUploadFile()
                .checkingFileAdded(uploadWorkoutDataModel);
        deleteWorkoutSteps
                .openDeletePage()
                .deleteWorkoutPage()
                .checkingWorkoutDeleted();
    }

    @Test
    @Description(value = "View workout details test")
    public void viewWorkoutDetailsTest() {
        initUploadWorkoutData();
        loginSteps
                .openLoginPage()
                .authentication();
        uploadWorkoutDataSteps
                .openUploadPage()
                .fillUploadWorkoutData(uploadWorkoutDataModel)
                .saveUploadFile()
                .checkingFileAdded(uploadWorkoutDataModel);
        viewWorkoutDetailsStep
                .openWorkoutsDetailsPage()
                .checkingWorkoutsDetailsPageOpened();
    }

    @Test
    @Description(value = "Upload workout data test")
    public void uploadWorkoutDataTest() {
        initUploadWorkoutData();
        loginSteps
                .openLoginPage()
                .authentication();
        uploadWorkoutDataSteps
                .openUploadPage()
                .fillUploadWorkoutData(uploadWorkoutDataModel)
                .saveUploadFile()
                .checkingFileAdded(uploadWorkoutDataModel);
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
        workoutQuickModel.setName("Run");
        workoutQuickModel.setWorkoutDate("5/11/2021");
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