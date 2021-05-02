package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class NewWorkoutQuickPage extends BasePage {

    private static final By WORKOUT_HEADER = By.id("WorkoutAddHeader");
    private static final By SAVE_BUTTON = By.id("saveButton");


    public NewWorkoutQuickPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(WORKOUT_HEADER));
        log.info("Checking that the new workout page has opened");
    }

    @Override
    public void openPage() {
    }

    public void saveNewWorkout() {
        log.info("Click {} in order to save new button", SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
    }
}