package steps;

import elements.DropdownSelectByVisibleText;
import elements.FileUpload;
import elements.Input;
import io.qameta.allure.Step;
import model.UploadWorkoutDataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.UploadWorkoutDataPage;

import static pages.BasePage.*;
import static pages.UploadWorkoutDataPage.PLUS;

public class UploadWorkoutDataSteps extends AbstractCalendarPageSteps {

    private static final String ACTUAL_ACTIVITY_TYPE = "//span[@class='activityTypeName']";

    public UploadWorkoutDataSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open upload workout data page ")
    public UploadWorkoutDataSteps openUploadPage() {
        uploadWorkoutDataPage = new UploadWorkoutDataPage(driver);
        openCalendarPage();
        calendarPage.openMenu(PLUS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
        uploadWorkoutDataPage.findUploadWorkoutDataButton(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
        validateComponentIsLoaded(uploadWorkoutDataPage);
        return this;
    }

    @Step("Fill in the upload workout data page fields")
    public UploadWorkoutDataSteps fillUploadWorkoutData() {
        new DropdownSelectByVisibleText(driver, "ActivityType").select(UploadWorkoutDataModel.activityType);
        new Input(driver, "WorkoutDateAdd").clear();
        new Input(driver, "WorkoutDateAdd").enterInput(UploadWorkoutDataModel.workoutDateAdd);
        new Input(driver, "Name").enterInput(UploadWorkoutDataModel.name);
        new Input(driver, "Desc").enterInput(UploadWorkoutDataModel.description);
        new FileUpload(driver).chooseFile();
        return this;
    }

    @Step("Upload file")
    public UploadWorkoutDataSteps uploadFile() {
        uploadWorkoutDataPage.clickUploadFileButton();
        return this;
    }

    @Step("Checking file was uploaded")
    public void checkingFileWasUploaded() {
        Assert.assertEquals(driver.findElement(By.xpath(ACTUAL_ACTIVITY_TYPE)).getText(),
                UploadWorkoutDataModel.activityType, "Entered data is not displayed");
        Assert.assertEquals(uploadWorkoutDataPage.getActualName(), UploadWorkoutDataModel.name, "Entered data is not displayed");
        Assert.assertEquals(uploadWorkoutDataPage.getActualActivityType(), UploadWorkoutDataModel.activityType, "Entered data is not displayed");
        Assert.assertEquals(uploadWorkoutDataPage.getActualDescription(), UploadWorkoutDataModel.description, "Entered data is not displayed");
    }
}

