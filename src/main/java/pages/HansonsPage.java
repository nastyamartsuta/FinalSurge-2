package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class HansonsPage extends BasePage {

    private static final By HANSONS_BUTTON = By.xpath("//a[@href='https://log.finalsurge.com/HansonsCalc.cshtml?c=1&ssl=1']");
    private static final By HEADER_HANSONS = By.xpath("//h4[contains(.,'HansonsPage Marathon Method Pace Calculator')]/ancestor::div[@class='w-box-header']");
    private static final By SAVE_BUTTON = By.xpath("//div[@id='CalcBox']//input[@id='saveButtonSettings']");
    private static final By RECENT_RACE_INFORMATION_HEADER = By.xpath("//h4[contains(.,'Recent Race Information')]/ancestor::div[@class='w-box-header']");
    private static final By TRAINING_PACES_HEADER = By.xpath("//h4[contains(.,'Training Paces (Adjusted)')]/ancestor::div[@class='w-box-header']");
    private static final By EQUIVALENT_RACE_PERFORMANCES_HEADER = By.xpath("//h4[contains(.,'Equivalent Race Performances')]/ancestor::div[@class='w-box-header']");
    private static final By ALERT_INFO = By.xpath("//div[@class='alert alert-info']");
    private static final By TABLE_TEXT = By.xpath("//h4[contains(.,'Recent Race Information')]/ancestor::div[@class='w-box w-box-green']//tr//td[2]");

    public HansonsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the HansonsPage page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_HANSONS));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open HansonsPage page", HANSONS_BUTTON);
        driver.findElement(HANSONS_BUTTON).click();
    }

    public void clickCalculatePacesButton() {
        log.info("Click {} in order to save paces", SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
    }

    public boolean checkCalculationsIsOpened() {
        log.info("Checking that the Recent race information was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(RECENT_RACE_INFORMATION_HEADER));
        log.info("Checking that the Training paces was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(TRAINING_PACES_HEADER));
        log.info("Checking that the Equivalent race performances was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(EQUIVALENT_RACE_PERFORMANCES_HEADER));
        log.info("Checking that the Alert info was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_INFO));
        return true;
    }

    public String text() {
        log.info("Get the text");
        WebElement element = driver.findElement(ALERT_INFO);
        return element.getText();
    }

    public String textInTable() {
        log.info("Get the text from the table");
        WebElement element = driver.findElement(TABLE_TEXT);
        return element.getText();
    }
}