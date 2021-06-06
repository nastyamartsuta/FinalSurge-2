package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class IntensityPage extends BasePage {

    private static final By INTENSITY_BUTTON = By.xpath("//button[contains(.,'Intensity')]");
    private static final By HEADER_INTENSITY = By.xpath("//h4[contains(.,'Running Workout Intensity Calculator')]/ancestor::div[@class='w-box-header']");
    private static final By SAVE_BUTTON = By.xpath("//div[@id='CalcBox']//input[@id='saveButtonSettings']");
    private static final By YOUR_WORKOUT_PACES_HEADER = By.xpath("//h4[contains(.,'Your Workout Paces')]/ancestor::div[@class='w-box-header']");
    private static final By EQUIVALENT_EVENT_PERFORMANCE_TIMES_HEADER = By.xpath("//h4[contains(.,'Equivalent Event Performance Times Based on your PR')]/ancestor::div[@class='w-box-header']");
    private static final By VO2_MAX_WORKOUT_SPLITS_HEADER = By.xpath("//h4[contains(.,'VO2 Max Workout Splits')]/ancestor::div[@class='w-box-header']");

    public IntensityPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Intensity page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_INTENSITY));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open HansonsPage page", INTENSITY_BUTTON);
        driver.findElement(INTENSITY_BUTTON).click();
    }

    public void clickCalculatePacesButton() {
        log.info("Click {} in order to save paces", SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
    }

    public boolean checkCalculationsIsOpened() {
        log.info("Checking that the Your Workout Paces was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(YOUR_WORKOUT_PACES_HEADER));
        log.info("Checking that the Equivalent Event Performance Times Based on your PR was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(EQUIVALENT_EVENT_PERFORMANCE_TIMES_HEADER));
        log.info("Checking that the VO2 Max Workout Splits was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(VO2_MAX_WORKOUT_SPLITS_HEADER));
        return true;
    }
}