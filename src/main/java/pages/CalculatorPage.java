package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CalculatorPage extends BasePage {

    private static final By CALCULATOR_BUTTON = By.className("icsw16-stop-watch");
    private static final By HEADER_CALCULATOR = By.xpath("//h4[contains(.,'Running Workout Intensity Calculator')]/ancestor::div[@class='w-box-header']");
    private static final String IFRAME_PATTERN = "IntensityCalciFrame";

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Calculator page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_CALCULATOR));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open calculator page", CALCULATOR_BUTTON);
        driver.findElement(CALCULATOR_BUTTON).click();
        driver.switchTo().frame(IFRAME_PATTERN);
    }
}
