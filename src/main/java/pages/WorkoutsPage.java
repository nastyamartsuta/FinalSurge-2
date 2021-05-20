package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class WorkoutsPage extends BasePage {

    private static final By WORKOUTS_BUTTON = By.xpath("//a[contains(.,'Workouts')]");
    private static final By ADD_WORKOUTS_BUTTON = By.xpath("//div[@id='fade-menu']//a[text()='Add Workout']");
    private static final By ADD_WORKOUTS_HEADER = By.id("AddWorkoutForm");
    private static final By ADD_NEW_WORKOUT_SWIM_BUTTON = By.xpath("//a[contains(.,'Swim')]/ancestor::div[@class='accordion-heading'] ");
    private static final By ADD_NEW_WORKOUT_HEADER = By.xpath("//h4[contains(.,'Add New Workout')]/ancestor::div[@class='w-box-header']");
    private static final By ADD_NEW_WORKOUT_BUTTON = By.id("saveButton");
    private static final By ACTUAL_INFORMATION = By.xpath("//div[@class='w-box-content cnt_a user_profile']");
    private static final By NEW_WORKOUT_DETAILS_HEADER = By.xpath("//h4[contains(.,'Workout Details')]/ancestor::div[@class='w-box-header']");

    public WorkoutsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Workouts page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(ADD_WORKOUTS_HEADER));
    }

    @Override
    public void openPage() {
        log.info("Move to {}", WORKOUTS_BUTTON);
        new Actions(driver)
                .moveToElement(driver.findElement(WORKOUTS_BUTTON))
                .perform();
        log.info("Click {} in order to open Workouts page", ADD_WORKOUTS_BUTTON);
        driver.findElement(ADD_WORKOUTS_BUTTON).click();
    }

    public void openAddNewWorkoutSwim() {
        log.info("Click {} in order to open new workout Swim panel", ADD_NEW_WORKOUT_SWIM_BUTTON);
        driver.findElement(ADD_NEW_WORKOUT_SWIM_BUTTON).click();
        log.info("Checking that the new workout Swim panel was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(ADD_NEW_WORKOUT_HEADER));
    }

    public void clickAddWorkoutsButton() {
        log.info("Click {} in order to add new workouts", ADD_NEW_WORKOUT_BUTTON);
        driver.findElement(ADD_NEW_WORKOUT_BUTTON).click();
    }
    public String getActualText() {
        log.info("Get the actual text");
        WebElement element = driver.findElement(ACTUAL_INFORMATION);
        return element.getText();
    }
    public boolean chekWorkoutDetailsIsOpen(){
        log.info("Checking that the new Workout Details was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(NEW_WORKOUT_DETAILS_HEADER));
        return true;
    }
}