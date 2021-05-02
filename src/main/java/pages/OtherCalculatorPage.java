package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class OtherCalculatorPage extends BasePage {

    private static final By OTHER_CALCULATOR_BUTTON = By.className("icsw16-calculator");
    private static final By HEADER_OTHER_CALCULATOR = By.xpath("//h4[contains(.,'Daily Caloric Needs Calculator')]/ancestor::div[@class='w-box-header']");
    private static final By TODAY_CALORIC_NEEDS_HEADER = By.xpath("//h4[contains(.,'Today')]/ancestor::div[@class='w-box-header']");

    public OtherCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Other Calculator page has opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_OTHER_CALCULATOR));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open other calculator page", OTHER_CALCULATOR_BUTTON);
        driver.findElement(OTHER_CALCULATOR_BUTTON).click();
        driver.switchTo().frame("OtherCalciFrame");
    }

    public boolean checkCalculationsIsOpened(){
        log.info("Checking that the Today's caloric needs has opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(TODAY_CALORIC_NEEDS_HEADER));
        return true;
    }
}
