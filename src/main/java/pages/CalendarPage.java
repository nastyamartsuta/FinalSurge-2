package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CalendarPage extends BasePage {

    private static final By CALENDAR = By.id("CalendarContent");
    private static final By CALENDAR_BUTTON = By.className("icsw16-day-calendar");
    private static final By NEW_WORKOUT = By.id("QuickAddToggle");


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

    public void createNewWorkout() {
        log.info("Click {} in order to new button", NEW_WORKOUT);
        driver.findElement(NEW_WORKOUT).click();
    }

}