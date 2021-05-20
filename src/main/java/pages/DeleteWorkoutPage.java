package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.UploadWorkoutDataPage.*;

@Log4j2
public class DeleteWorkoutPage extends BasePage {

    private static final String DATA_PATTERN = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']";
    private static final String WORKOUTS = "//td//div[@data-date='%s/%s/%s']";
    private static final String DELETE_WORKOUT_DATA_BUTTON = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']//div[@class='fc-day-content']//li[contains(.,'Delete')]";
    private static final By MODAL_WINDOW_HEADER = By.xpath("//div[@class='modal-body']");
    private static final By OK_BUTTON = By.xpath("//a[contains(.,'OK')]");

    public DeleteWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Delete Workout page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(MODAL_WINDOW_HEADER));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open Delete Workout page", DATA_PATTERN);
        new Actions(driver)
                .moveToElement(findData(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN))
                .perform();
        selectWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN).click();
        findDeleteWorkoutButton(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN).click();
    }

    public WebElement findData(String day, String month, String year) {
        return driver.findElement(By.xpath(String.format(DATA_PATTERN, day, month, year)));
    }

    public WebElement selectWorkout(String month, String day, String year) {
        return driver.findElement(By.xpath(String.format(WORKOUTS, day, month, year)));
    }

    public WebElement findDeleteWorkoutButton(String day, String month, String year) {
        return driver.findElement(By.xpath(String.format(DELETE_WORKOUT_DATA_BUTTON, day, month, year)));
    }

    public void clickDeleteButton() {
        log.info("Click {} in order to delete workout", OK_BUTTON);
        driver.findElement(OK_BUTTON).click();
    }

    public boolean checkingWorkoutDeleted() {
        log.info("Checking that the workout was deleted");
        explicitlyWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements
                (By.xpath(String.format(WORKOUTS, MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN)))));
        return true;
    }
}
