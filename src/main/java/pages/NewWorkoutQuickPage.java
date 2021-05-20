package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class NewWorkoutQuickPage extends BasePage {

    private static final By WORKOUT_HEADER = By.id("WorkoutAddHeader");
    private static final By SAVE_BUTTON = By.id("saveButton");
    private static final String WORKOUTS = "//td//div[@data-date='%s/%s/%s']";
    public static final String DAY_PATTERN = "11";
    public static final String MONTH_PATTERN = "5";
    public static final String YEAR_PATTERN = "2021";
    public static final String ACTUAL_TEXT = "//td//div[@data-date='%s/%s/%s']//div[@class='fc-event-inner fc-event-skin']";

    public NewWorkoutQuickPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the new workout page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(WORKOUT_HEADER));
    }

    @Override
    public void openPage() {}

    public void saveNewWorkout() {
        log.info("Click {} in order to save new button", SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
    }

    public boolean checkingWorkoutAdded() {
        log.info("Checking that a workout was added");
        explicitlyWait.until(ExpectedConditions.visibilityOf (driver.findElement
                (By.xpath(String.format(WORKOUTS, MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN)))));
        return true;
    }

    public String getText() {
        log.info("Get the actual text");
        return driver.findElement(By.xpath(String.format(ACTUAL_TEXT, MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN))).getText();
    }
}