package finalsurgetest;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static pages.MoveWorkoutPage.*;

public class CalendarTest extends WithLoginTest {

    @Test
    @Description(value = "Delete workout test")
    public void deleteUploadedWorkoutTest() {
        uploadWorkoutDataSteps
                .openUploadPage()
                .fillUploadWorkoutData()
                .uploadFile()
                .checkingFileWasUploaded();
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .deleteWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .checkingWorkoutWasDeleted();
    }

    @Test
    @Description(value = "Add workout quick test")
    public void addWorkoutQuickTest() {
        addWorkoutQuickSteps
                .openNewWorkoutQuickPage()
                .fillNewWorkoutQuickPage()
                .saveNewQuickWorkout()
                .checkingNewWorkoutQuickWasAdded();
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .deleteWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
    }

    @Test
    @Description(value = "Move workout test")
    public void moveWorkoutTest() {
        addWorkoutQuickSteps
                .openNewWorkoutQuickPage()
                .fillNewWorkoutQuickPage()
                .saveNewQuickWorkout()
                .checkingNewWorkoutQuickWasAdded();
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
        addWorkoutQuickSteps
                .openNewWorkoutQuickPage()
                .fillNewWorkoutQuickPage()
                .saveNewQuickWorkout()
                .checkingNewWorkoutQuickWasAdded();
        commentsStep
                .openNewCommentPage()
                .sendComment()
                .saveNewComment()
                .checkingNewCommentWasAdded()
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
    public void viewWorkoutDetailsTest(){
        uploadWorkoutDataSteps
                .openUploadPage()
                .fillUploadWorkoutData()
                .uploadFile()
                .checkingFileWasUploaded();
        viewWorkoutDetailsStep
                .openWorkoutsDetailsPage()
                .checkingWorkoutsDetailsPageWasOpened();
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .deleteWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
    }

    @Test
    @Description(value = "Upload workout data test")
    public void uploadWorkoutDataTest(){
        uploadWorkoutDataSteps
                .openUploadPage()
                .fillUploadWorkoutData()
                .uploadFile()
                .checkingFileWasUploaded();
        deleteWorkoutSteps
                .openDeletePage(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN)
                .deleteWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
    }

    @AfterMethod
    @Override
    public void tearDown() {
        driver.switchTo().defaultContent();
        super.tearDown();
    }
}