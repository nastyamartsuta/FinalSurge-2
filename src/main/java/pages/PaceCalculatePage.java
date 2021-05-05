package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class PaceCalculatePage extends BasePage {

    private static final By PACE_CALCULATOR_BUTTON = By.xpath("//a[@href='https://log.finalsurge.com/PaceCalc.cshtml?c=1&ssl=1']");
    private static final By HEADER_PACE_CALCULATOR = By.xpath("//h4[contains(.,'Daily Caloric Needs Calculator')]/ancestor::div[@class='w-box-header']");
    private static final By SAVE_BUTTON = By.xpath("//h4[contains(.,'Pace Calculator')]/ancestor::div[@class='w-box w-box-blue']//input[@id='saveButtonSettings']");
    private static final By PACE_CHART_HEADER = By.xpath("//h4[contains(.,'Pace Chart')]/ancestor::div[@class='w-box-header']");
    private static final By PACE_SPLITS_HEADER = By.xpath("//h4[contains(.,'Pace Splits')]/ancestor::div[@class='w-box-header']");

    public PaceCalculatePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Pace calculator page has opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_PACE_CALCULATOR));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open Pace calculator page", PACE_CALCULATOR_BUTTON);
        driver.findElement(PACE_CALCULATOR_BUTTON).click();
    }

    public void saveCalculatePaces() {
        log.info("Click {} in order to save paces", SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
    }

    public boolean checkCalculationsIsOpened(){
        log.info("Checking that the Pace chart ang Pace split has opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(PACE_CHART_HEADER));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(PACE_SPLITS_HEADER));
        return true;
    }
}
