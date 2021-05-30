package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class MoveWorkoutPage extends CalendarPage {

    public static final String MOVE_DAY_PATTERN = "3";
    public static final String MOVE_MONTH_PATTERN = "5";
    public static final String MOVE_YEAR_PATTERN = "2021";
    private static final String MOVE_WORKOUT_BUTTON = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']//div[@class='fc-day-content']//li[contains(.,'Move')]";
    private static final By TRAINING_DAY_BEFORE_MOVE = By.xpath("//div[@class='datepicker dropdown-menu' and contains(@style,'display: block')]//td[@class='day  active']");
    private static final By TRAINING_DAY_AFTER_MOVE = By.xpath("//div[@class='datepicker dropdown-menu' and contains(@style,'display: block')]//td[@class='day  active']//ancestor::tbody/tr[2]/td[2]");

    public MoveWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Move panel was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(TRAINING_DAY_BEFORE_MOVE));
    }

    public void findMoveWorkoutButton(String day, String month, String year) {
        WebElement element = driver.findElement(By.xpath(String.format(MOVE_WORKOUT_BUTTON, day, month, year)));
        element.click();
    }

    public String selectNewWorkoutDay() {
        log.info("Select a new workout day");
        WebElement selectNewWorkoutsDay = driver.findElement(TRAINING_DAY_AFTER_MOVE);
        String newDay = selectNewWorkoutsDay.getText();
        selectNewWorkoutsDay.click();
        return newDay;
    }

    public boolean checkingPreviousDataIsNull() {
        log.info("Checking that the workout is not on the previous date");
        explicitlyWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath(String.format(WORKOUTS, MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN))));
        return true;
    }

    public boolean checkingWorkoutWasMoved(String month, String newDay, String year) {
        log.info("Checking Workout day was move");
        explicitlyWait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath(String.format(WORKOUTS, month, newDay, year)))));
        return true;
    }
}
