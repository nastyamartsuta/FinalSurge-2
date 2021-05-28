package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.UploadWorkoutDataPage.*;


@Log4j2
public class ViewWorkoutPage extends CalendarPage {

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

    public void findViewButton(String day, String month, String year) {
       WebElement element = driver.findElement(By.xpath(String.format(VIEW_WORKOUT_DATA_BUTTON, day, month, year)));
       element.click();
    }
}
