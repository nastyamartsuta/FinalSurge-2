package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class AddCommentPage extends BasePage {

    private static final String DATA_PATTERN = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']";
    private static final String WORKOUTS = "//td//div[@data-date='%s/%s/%s']";
    private static final String ADD_WORKOUT_BUTTON = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']//div[@class='fc-day-content']//li[contains(.,'Comments')]";
    private static final By WORKOUT_COMMENT_HEADER = By.xpath("//h4[contains(.,'Workout Comments')]/ancestor::div[@class='w-box-header']");
    private static final By ADD_COMMENT_BUTTON = By.id("saveButtonComment");
    public static final String DAY_PATTERN = "11";
    public static final String MONTH_PATTERN = "5";
    public static final String YEAR_PATTERN = "2021";
    private static final By NEW_COMMENT_HEADER = By.xpath("//h4[contains(.,'Comments')]/ancestor::div[@class='w-box-header']");
    private static final By ADDED_COMMENT = By.xpath("//div[@class='ch-content']");
    private static final String IFRAME_PATTERN = "WorkoutCommentsiFrame";
    private static final By DELETE_NEW_COMMENT = By.xpath("//i[@class='icon-trash']");
    private static final By OK_BUTTON = By.xpath("//a[contains(.,'OK')]");

    public AddCommentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Comment page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(WORKOUT_COMMENT_HEADER));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open Comment page", DATA_PATTERN);
        new Actions(driver)
                .moveToElement(findData(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN))
                .perform();
        selectWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN).click();
        findAddCommentsButton(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN).click();
        driver.switchTo().frame(IFRAME_PATTERN);
    }

    public WebElement findData(String day, String month, String year) {
        return driver.findElement(By.xpath(String.format(DATA_PATTERN, day, month, year)));
    }

    public WebElement selectWorkout(String month, String day, String year) {
        return driver.findElement(By.xpath(String.format(WORKOUTS, day, month, year)));
    }

    public WebElement findAddCommentsButton(String day, String month, String year) {
        return driver.findElement(By.xpath(String.format(ADD_WORKOUT_BUTTON , day, month, year)));
    }

    public void addCommentButton() {
        log.info("Click {} in order to add comment", ADD_COMMENT_BUTTON);
        driver.findElement(ADD_COMMENT_BUTTON).click();
    }

    public boolean checkingCommentAdded() {
        log.info("Checking that the comment was added");
        explicitlyWait.until(ExpectedConditions.visibilityOf(driver.findElement(NEW_COMMENT_HEADER)));
        return true;
    }

    public String getActualTextComment() {
        log.info("Get the actual text of the comment");
        return driver.findElement(ADDED_COMMENT).getText();
    }

    public void deleteCommentButton() {
        log.info("Click {} in order to delete comment", DELETE_NEW_COMMENT);
        driver.findElement(DELETE_NEW_COMMENT).click();
        explicitlyWait.until(ExpectedConditions.visibilityOf(driver.findElement(OK_BUTTON))).click();
    }
    public boolean checkingNewCommentDeleted() {
        log.info("Checking that the new comment was deleted");
        explicitlyWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements
                (ADDED_COMMENT)));
        return true;
    }
}

