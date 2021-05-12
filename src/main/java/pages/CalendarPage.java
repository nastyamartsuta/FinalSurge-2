package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CalendarPage extends BasePage {

    private static final By CALENDAR = By.id("CalendarContent");
    private static final By CALENDAR_BUTTON = By.className("icsw16-day-calendar");
    private static final By QUICK_ADD_WORKOUT = By.id("QuickAddToggle");
    private static final By WORKOUT_LIBRARY_BUTTON = By.id("WorkoutLibAdd");
    private static final By WORKOUT_LIBRARY_HEADER = By.xpath("//h4[contains(.,'Workout Library')]/ancestor::div[@class='w-box-header']");
    private static final By LIBRARY = By.xpath("//option[contains(.,'Run')]/ancestor::div[@class='w-box-content']//ul");


    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Calender page has opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(CALENDAR));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open calendar page", CALENDAR_BUTTON);
        driver.findElement(CALENDAR_BUTTON).click();
    }

    public void openQuickAddPanel() {
        log.info("Click {} in order to open quick add panel", QUICK_ADD_WORKOUT);
        driver.findElement(QUICK_ADD_WORKOUT).click();
    }

    public void openWorkoutLibraryPanel() {
        log.info("Click {} in order to open workout library", WORKOUT_LIBRARY_BUTTON);
        driver.findElement(WORKOUT_LIBRARY_BUTTON).click();
        log.info("Checking that the workout library panel has open");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(WORKOUT_LIBRARY_HEADER));
    }

    public boolean checkingLibraryIsOpen() {
        log.info("Checking that the workout library panel has open");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LIBRARY));
        return false;
    }
}