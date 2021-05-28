package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class UploadWorkoutDataPage extends CalendarPage {

    private static final String DATA_PATTERN = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']";
    public static final String PLUS = "//td[@data-month='%s' and @data-day='%s' and @data-year='%s']//i[@class='icon-plus']";
    private static final String UPLOAD_WORKOUT_DATA_BUTTON = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']//li[contains(.,'Upload Data')]";
    private static final By UPLOAD_WORKOUT_DATA_HEADER = By.xpath("//h4[contains(.,'Upload Workout Data')]/ancestor::div[@class='w-box-header']");
    private static final By UPLOAD_FILE_BUTTON = By.id("saveButton");
    private static final String IFRAME_PATTERN = "WorkoutUploadiFrame";

    public UploadWorkoutDataPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Upload Workout Data page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(UPLOAD_WORKOUT_DATA_HEADER));
    }

    public void findUploadWorkoutDataButton(String day, String month, String year) {
       WebElement  element = driver.findElement(By.xpath(String.format(UPLOAD_WORKOUT_DATA_BUTTON, day, month, year)));
       element.click();
       driver.switchTo().frame(IFRAME_PATTERN);
    }

    public void clickUploadFileButton() {
        log.info("Click {} in order to save upload", UPLOAD_FILE_BUTTON);
        driver.findElement(UPLOAD_FILE_BUTTON).click();
    }

    public String text(String day, String month, String year) {
        log.info("Get the actual text");
        WebElement element = driver.findElement(By.xpath(String.format(DATA_PATTERN, day, month, year)));
        return element.getText();
    }
}
