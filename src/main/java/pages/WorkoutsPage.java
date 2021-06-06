package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.StringUtils;

@Log4j2
public class WorkoutsPage extends BasePage {

    private static final By WORKOUTS_BUTTON = By.xpath("//a[contains(.,'Workouts')]");
    private static final By ADD_WORKOUTS_BUTTON = By.xpath("//div[@id='fade-menu']//a[text()='Add Workout']");
    private static final By ADD_WORKOUTS_HEADER = By.id("AddWorkoutForm");
    private static final By ADD_NEW_WORKOUT_SWIM_BUTTON = By.xpath("//a[contains(.,'Swim')]/ancestor::div[@class='accordion-heading'] ");
    private static final By ADD_NEW_WORKOUT_HEADER = By.xpath("//h4[contains(.,'Add New Workout')]/ancestor::div[@class='w-box-header']");
    private static final By ADD_NEW_WORKOUT_BUTTON = By.id("saveButton");
    private static final By NEW_WORKOUT_DETAILS_HEADER = By.xpath("//h4[contains(.,'Workout Details')]/ancestor::div[@class='w-box-header']");
    private static final By ACTUAL_TIME_OF_DAY = By.xpath("//div[@class='formSep']/div/small");
    private static final By ACTUAL_WORKOUT_NAME = By.xpath("//div[@class='formSep']/div[3]");
    private static final By ACTUAL_WORKOUT_DESCRIPTION = By.xpath("//small[contains(.,'Workout Description:')]/ancestor::p");
    private static final By ACTUAL_DISTANCE_DURATION = By.xpath("//span[@class='label label-info']");
    private static final By ACTUAL_PERCEIVED_EFFORT = By.xpath("//div[@class='formSep'][3]");
    private static final By ACTUAL_CALORIES = By.xpath("//p[@class='formSep']/span");

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

    public boolean chekWorkoutDetailsIsOpen() {
        log.info("Checking that the new Workout Details was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(NEW_WORKOUT_DETAILS_HEADER));
        return true;
    }

    public String getActualTimeOfDay() {
        log.info("Get the actual time of day");
        WebElement element = driver.findElement(ACTUAL_TIME_OF_DAY);
        return element.getText().split("-")[1].trim();
    }

    public String getActualWorkoutName() {
        log.info("Get the actual workout name");
        WebElement element = driver.findElement(ACTUAL_WORKOUT_NAME);
        return element.getText().trim();
    }

    public String getActualWorkoutDescription() {
        log.info("Get the actual workout description");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_WORKOUT_DESCRIPTION);
        return nodeText.trim();
    }

    public String getActualDistance() {
        log.info("Get the actual distance");
        WebElement element = driver.findElement(ACTUAL_DISTANCE_DURATION);
        String elementPrefix = element.getText().split("~")[0].trim();
        return elementPrefix.split(" ")[0];
    }

    public String getActualDistanceType() {
        log.info("Get the actual distance type");
        WebElement element = driver.findElement(ACTUAL_DISTANCE_DURATION);
        String elementPrefix = element.getText().split("~")[0].trim();
        return elementPrefix.split(" ")[1];
    }

    public String getActualDuration() {
        log.info("Get the actual duration");
        WebElement element = driver.findElement(ACTUAL_DISTANCE_DURATION);
        return element.getText().split("~")[1].trim();
    }

    public String getActualPerceivedEffort() {
        log.info("Get the actual perceived effort");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_PERCEIVED_EFFORT);
        return nodeText.trim();
    }

    public String getActualCalories() {
        log.info("Get the actual calories");
        String nodeText = StringUtils.getWebElementText(driver, ACTUAL_CALORIES);
        return nodeText.trim().split(" ")[0];
    }
}