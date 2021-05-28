package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class McMillanPage extends BasePage {

    private static final By MCMILLAN_BUTTON = By.xpath("//a[@href='https://log.finalsurge.com/McMillanCalc.cshtml?c=1&ssl=1']");
    private static final By HEADER_MCMILLAN = By.xpath("//h4[contains(.,'Running Workout Intensity Calculator')]/ancestor::div[@class='w-box-header']");
    private static final By SAVE_BUTTON = By.xpath("//div[@id='CalcBox']//input[@id='saveButtonSettings']");
    private static final By MCMILLAN_RUNNING_CALCULATOR_HEADER = By.xpath("//h4[contains(.,'McMillan Running Calculator')]/ancestor::div[@class='w-box-header']");
    private static final By TRAINING_PACES_HEADER = By.xpath("//h4[contains(.,'Training Paces')]/ancestor::div[@class='w-box-header']");
    private static final By CURRENT_RACE_TIMES_HEADER = By.xpath("//h4[contains(.,'Current Race Times')]/ancestor::div[@class='w-box-header']");
    private static final By GOAL_RACE_TIME_HEADER = By.xpath("//h4[contains(.,'Goal Race Times')]/ancestor::div[@class='w-box-header']");
    private static final By ACTUAL_INFORMATION = By.xpath("//div[@id='CalcBox']/div/div/div[2]");

    public McMillanPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the McMillanModel page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_MCMILLAN));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open McMillanModel page", MCMILLAN_BUTTON);
        driver.findElement(MCMILLAN_BUTTON).click();
    }

    public void clickCalculatePacesButton() {
        log.info("Click {} in order to save paces", SAVE_BUTTON);
        driver.findElement(SAVE_BUTTON).click();
    }

    public boolean checkCalculationsIsOpened() {
        log.info("Checking that the McMillanModel Running Calculator was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(MCMILLAN_RUNNING_CALCULATOR_HEADER));
        log.info("Checking that the Training Paces was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(TRAINING_PACES_HEADER));
        log.info("Checking that the Current Race Times was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(CURRENT_RACE_TIMES_HEADER));
        log.info("Checking that the Goal Race Times was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(GOAL_RACE_TIME_HEADER));
        return true;
    }

    public String text() {
        log.info("Get the text");
        WebElement element = driver.findElement(ACTUAL_INFORMATION);
        return element.getText();
    }
}
