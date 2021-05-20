package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class TinmanPage extends BasePage {

    private static final By TINMAN_BUTTON = By.xpath("//a[@href='https://log.finalsurge.com/TinmanCalc.cshtml?c=1&ssl=1']");
    private static final By HEADER_TINMAN= By.xpath("//h4[contains(.,'Running Workout Intensity Calculator')]/ancestor::div[@class='w-box-header']");
    private static final By SAVE_BUTTON = By.xpath("//div[@id='CalcBox']//input[@id='saveButtonSettings']");
    private static final By RACE_INFORMATION_HEADER = By.xpath("//h4[contains(.,'Race Information')]/ancestor::div[@class='w-box-header']");
    private static final By RACE_SPLITS_HEADER = By.xpath("//h4[contains(.,'Race Splits')]/ancestor::div[@class='w-box-header']");
    private static final By TRAINING_PACES_BY_INTENSITY_HEADER = By.xpath("//h4[contains(.,'Training Paces By Intensity')]/ancestor::div[@class='w-box-header']");
    private static final By EQUIVALENT_RACE_TIMES_HEADER = By.xpath("//h4[contains(.,'Equivalent Race Times')]/ancestor::div[@class='w-box-header']");


    public TinmanPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Tinman page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_TINMAN));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open Tinman page", TINMAN_BUTTON);
        driver.findElement(TINMAN_BUTTON).click();
    }

    public void clickCalculatePacesButton() {
        log.info("Click {} in order to save paces", SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
    }

    public boolean checkCalculationsIsOpened() {
        log.info("Checking that the Race Information was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(RACE_INFORMATION_HEADER));
        log.info("Checking that the Race Splits was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(RACE_SPLITS_HEADER));
        log.info("Checking that the Training Paces By Intensity was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(TRAINING_PACES_BY_INTENSITY_HEADER));
        log.info("Checking that the Equivalent Race Times was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(EQUIVALENT_RACE_TIMES_HEADER));
        return true;
    }
}