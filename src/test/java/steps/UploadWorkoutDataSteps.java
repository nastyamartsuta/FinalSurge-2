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
    private static final String ACTUAL_DESCRIPTION = "//p[@class=' testme dont-break-out']";

    public UploadWorkoutDataSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public UploadWorkoutDataSteps openUploadPage() {
        uploadWorkoutDataPage = new UploadWorkoutDataPage(driver);
        openCalendarPage();
        calendarPage.openMenu(PLUS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
        uploadWorkoutDataPage.findUploadWorkoutDataButton(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
        validateComponentIsLoaded(uploadWorkoutDataPage);
        return this;
    }

    @Step
    public UploadWorkoutDataSteps fillUploadWorkoutData(UploadWorkoutDataModel uploadWorkoutDataModel) throws InterruptedException {

        new DropdownSelectByVisibleText(driver, "ActivityType").select(uploadWorkoutDataModel.getActivityType());
        new Input(driver, "WorkoutDateAdd").clear();
        new Input(driver, "WorkoutDateAdd").enterInput(uploadWorkoutDataModel.getWorkoutDateAdd());
        new Input(driver, "Name").enterInput(uploadWorkoutDataModel.getName());
        new Input(driver, "Desc").enterInput(uploadWorkoutDataModel.getDescription());
        new FileUpload(driver).chooseFile();
        return this;
    }

    @Step
    public UploadWorkoutDataSteps saveUploadFile() {
        uploadWorkoutDataPage.clickUploadFileButton();
        return this;
    }

    //TODO
    @Step
    public void checkingFileAdded(UploadWorkoutDataModel uploadWorkoutDataModel) {
        Assert.assertEquals(driver.findElement(By.xpath(ACTUAL_ACTIVITY_TYPE)).getText(),
                uploadWorkoutDataModel.getActivityType(), "Entered data is not displayed");
        Assert.assertEquals(driver.findElement(By.xpath(ACTUAL_DESCRIPTION)).getText(),
                "Workout Description:" + "\n" +
                        uploadWorkoutDataModel.getDescription(), "Entered data is not displayed");
    }
}

