package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class NewWorkoutQuickPage extends BasePage {

    private static final By WORKOUT_HEADER = By.id("WorkoutAddHeader");
    private static final By SAVE_BUTTON = By.id("saveButton");
    private static final String WORKOUTS = "//td//div[@data-date='%s/%s/%s']";
    private static final String ACTUAL_QUICK_WORKOUT_ACTIVITY_TYPE = "//td//div[@data-date='%s/%s/%s']//div[@class='fc-event-activity-title']";
    private static final String ACTUAL_QUICK_WORKOUT_TIME = "//td//div[@data-date='%s/%s/%s']//div[@class='fc-event-workouttime']";
    private static final String ACTUAL_QUICK_WORKOUT_DISTANCE = "//td//div[@data-date='%s/%s/%s']//div[@class='fc-event-activity-amounts']";

    public NewWorkoutQuickPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the new workout page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(WORKOUT_HEADER));
    }

    @Override
    public void openPage() {
    }

    public void saveNewWorkout() {
        log.info("Click {} in order to save new button", SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
    }

    public boolean checkingWorkoutAdded() {
        log.info("Checking that a workout was added");
        explicitlyWait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath(String.format(WORKOUTS, MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN)))));
        return true;
    }

    public String getActualQuickWorkoutType() {
        log.info("Get the actual quick workout type");
        WebElement element = driver.findElement(By.xpath(String.format(
                ACTUAL_QUICK_WORKOUT_ACTIVITY_TYPE, MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN)));
        return element.getText().split(":")[0].trim();
    }

    public String getActualQuickWorkoutName() {
        log.info("Get the actual quick workout name");
        WebElement element = driver.findElement(By.xpath(String.format(
                ACTUAL_QUICK_WORKOUT_ACTIVITY_TYPE, MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN)));
        return element.getText().split(":")[1].trim();
    }

    public String getActualQuickWorkoutTime() {
        log.info("Get the actual quick workout time");
        WebElement element = driver.findElement(By.xpath(String.format(
                ACTUAL_QUICK_WORKOUT_TIME, MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN)));
        return element.getText();
    }

    public String getActualQuickWorkoutDistance() {
        log.info("Get the actual quick workout distance");
        WebElement element = driver.findElement(By.xpath(String.format(
                ACTUAL_QUICK_WORKOUT_DISTANCE, MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN)));
        return element.getText().split("~")[0].split(" ")[0].trim();
    }

    public String getActualQuickWorkoutDistanceType() {
        log.info("Get the actual quick workout distance type");
        WebElement element = driver.findElement(By.xpath(String.format(
                ACTUAL_QUICK_WORKOUT_DISTANCE, MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN)));
        return element.getText().split("~")[0].split(" ")[1].trim();
    }

    public String getActualQuickWorkoutDuration() {
        log.info("Get the actual quick workout distance type");
        WebElement element = driver.findElement(By.xpath(String.format(
                ACTUAL_QUICK_WORKOUT_DISTANCE, MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN)));
        return element.getText().split("~")[1].trim();
    }
}