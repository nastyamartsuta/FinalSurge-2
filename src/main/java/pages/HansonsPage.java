package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class HansonsPage extends BasePage {

    private static final By HANSONS_BUTTON = By.xpath("//a[@href='https://log.finalsurge.com/HansonsCalc.cshtml?c=1&ssl=1']");
    private static final By HEADER_HANSONS = By.xpath("//h4[contains(.,'HansonsPage Marathon Method Pace Calculator')]/ancestor::div[@class='w-box-header']");
    private static final By SAVE_BUTTON = By.xpath("//h4[contains(.,'HansonsPage Marathon Method Pace Calculator')]/ancestor::div[@class='w-box w-box-blue']//input[@id='saveButtonSettings']");

    public HansonsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the HansonsPage page has opened");
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
}