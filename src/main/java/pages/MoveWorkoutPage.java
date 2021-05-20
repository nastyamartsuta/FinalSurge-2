package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class MoveWorkoutPage extends BasePage {

    private static final String DATA_PATTERN = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']";
    private static final String WORKOUTS = "//td//div[@data-date='%s/%s/%s']";
    private static final String MOVE_WORKOUT_BUTTON = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']//div[@class='fc-day-content']//li[contains(.,'Move')]";
    private static final By TRAINING_DAY_BEFORE_MOVE = By.xpath("//div[@class='datepicker dropdown-menu' and contains(@style,'display: block')]//td[@class='day  active']");
    private static final By TRAINING_DAY_AFTER_MOVE = By.xpath("//div[@class='datepicker dropdown-menu' and contains(@style,'display: block')]//td[@class='day  active']//ancestor::tbody/tr[2]/td[2]");
    public static final String DAY_PATTERN = "11";
    public static final String MONTH_PATTERN = "5";
    public static final String YEAR_PATTERN = "2021";


    public MoveWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Move panel was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(TRAINING_DAY_BEFORE_MOVE));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open Move panel", DATA_PATTERN);
        new Actions(driver)
                .moveToElement(findData(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN))
                .perform();
        selectWorkout(MONTH_PATTERN, DAY_PATTERN, YEAR_PATTERN).click();
        findMoveWorkoutButton(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN).click();
    }

    public WebElement findData(String day, String month, String year) {
        return driver.findElement(By.xpath(String.format(DATA_PATTERN, day, month, year)));
    }

    public WebElement selectWorkout(String month, String day, String year) {
        return driver.findElement(By.xpath(String.format(WORKOUTS, month, day, year)));
    }

    public WebElement findMoveWorkoutButton(String day, String month, String year) {
        return driver.findElement(By.xpath(String.format(MOVE_WORKOUT_BUTTON, day, month, year)));
    }

    public String selectNewWorkoutDay() {
        log.info("Select a new workout day");
        WebElement selectNewWorkoutsDay = driver.findElement(TRAINING_DAY_AFTER_MOVE);
        String newDay = selectNewWorkoutsDay.getText();
        selectNewWorkoutsDay.click();
        return newDay;
    }

    public boolean checkingCommentAdded(String month, String newDay, String year) {
        log.info("Checking Workout day was move");
        explicitlyWait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath(String.format(WORKOUTS, month, newDay, year)))));
        return true;
    }
}
