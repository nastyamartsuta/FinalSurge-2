package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CaloricNeedsPage extends BasePage {

    private static final By CALORIC_NEEDS_BUTTON = By.xpath("//button[contains(.,'Caloric Needs')]");
    private static final By HEADER_CALORIC_NEEDS = By.xpath("//h4[contains(.,'Daily Caloric Needs Calculator')]/ancestor::div[@class='w-box-header']");
    private static final By SAVE_BUTTON = By.xpath("//h4[contains(.,'Daily Caloric Needs Calculator')]/ancestor::div[@class='w-box w-box-blue']//input[@id='saveButtonSettings']");
    private static final By TODAY_CALORIC_NEEDS_HEADER = By.xpath("//h4[contains(.,'Today')]/ancestor::div[@class='w-box-header']");

    public CaloricNeedsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Caloric Needs Page page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_CALORIC_NEEDS));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open Caloric Needs Page page", CALORIC_NEEDS_BUTTON);
        driver.findElement(CALORIC_NEEDS_BUTTON).click();
    }

    public void saveCalculateCaloricNeeds() {
        log.info("Click {} in order to save paces", SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
    }
    public boolean checkCalculationsIsOpened(){
        log.info("Checking that the Today's caloric needs was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(TODAY_CALORIC_NEEDS_HEADER));
        return true;
    }
}