package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverUtils;

@Log4j2
public class CalendarPage extends BasePage {

    private static final By CALENDAR = By.id("CalendarContent");
    private static final By CALENDAR_BUTTON = By.className("icsw16-day-calendar");
    private static final By QUICK_ADD_WORKOUT = By.id("QuickAddToggle");
    private static final By WORKOUT_LIBRARY_BUTTON = By.id("WorkoutLibAdd");
    private static final By WORKOUT_LIBRARY_HEADER = By.xpath("//h4[contains(.,'Workout Library')]/ancestor::div[@class='w-box-header']");
    private static final By LIBRARY = By.xpath("//option[contains(.,'Run')]/ancestor::div[@class='w-box-content']//ul");
    private static final String DATA_PATTERN = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']";
    public static final String WORKOUTS = "//td//div[@data-date='%s/%s/%s']";

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Calender page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(CALENDAR));
    }

    @Override
    public void openPage() {
        log.info("Scroll to the top");
        DriverUtils.scrollToTop(driver);
        log.info("Click {} in order to open calendar page", CALENDAR_BUTTON);
        explicitlyWait.until(ExpectedConditions.elementToBeClickable(CALENDAR_BUTTON)).click();
    }

    public void openQuickAddPanel() {
        log.info("Click {} in order to open quick add panel", QUICK_ADD_WORKOUT);
        driver.findElement(QUICK_ADD_WORKOUT).click();
    }

    public void openWorkoutLibraryPanel() {
        log.info("Click {} in order to open workout library", WORKOUT_LIBRARY_BUTTON);
        driver.findElement(WORKOUT_LIBRARY_BUTTON).click();
        log.info("Checking that the workout library panel was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(WORKOUT_LIBRARY_HEADER));
    }

    public boolean checkingLibraryIsOpen() {
        log.info("Checking that the workout library panel was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LIBRARY));
        return true;
    }

    public void openMenu(String locator, String day, String month, String year) {
        log.info("Click {} in order to open Delete Workout", DATA_PATTERN);
        new Actions(driver)
                .moveToElement(findData(day, month, year))
                .perform();
        selectWorkout(locator, day, month, year).click();
    }

    private WebElement findData(String day, String month, String year) {
        return driver.findElement(By.xpath(String.format(DATA_PATTERN, day, month, year)));
    }

    private WebElement selectWorkout(String locator, String month, String day, String year) {
        return driver.findElement(By.xpath(String.format(locator, day, month, year)));
    }
}