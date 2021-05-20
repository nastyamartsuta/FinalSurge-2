package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.UploadWorkoutDataPage.*;
import static pages.UploadWorkoutDataPage.YEAR_PATTERN;


@Log4j2
public class ViewWorkoutPage extends BasePage {

    private static final String DATA_PATTERN = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']";

    private static final String WORKOUTS = "//td//div[@data-date='%s/%s/%s']";
    private static final String VIEW_WORKOUT_DATA_BUTTON = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']//div[@class='fc-day-content']//li[contains(.,'View')]";
    private static final By VIEW_WORKOUT_DATA_HEADER = By.xpath("//h4[contains(.,'Workout Details')]/ancestor::div[@class='w-box-header']");

    public ViewWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Workout Details page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(VIEW_WORKOUT_DATA_HEADER));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open Workout Details page", DATA_PATTERN);
        new Actions(driver)
                .moveToElement(findData(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN))
                .perform();
        selectWorkout(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN).click();
        findViewButton(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN).click();
    }

    public WebElement findData(String day, String month, String year) {
        return driver.findElement(By.xpath(String.format(DATA_PATTERN, day, month, year)));
    }

    public WebElement selectWorkout(String month, String day, String year) {
        return driver.findElement(By.xpath(String.format(WORKOUTS, day, month, year)));
    }

    public WebElement findViewButton(String day, String month, String year) {
        return driver.findElement(By.xpath(String.format(VIEW_WORKOUT_DATA_BUTTON, day, month, year)));
    }
}
