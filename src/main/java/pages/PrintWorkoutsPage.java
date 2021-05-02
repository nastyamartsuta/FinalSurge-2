package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class PrintWorkoutsPage extends BasePage {

    private static final By PRINT_WORKOUTS_PAGE_BUTTON = By.className("icsw16-printer");
    private static final By PRINT_WORKOUTS_HEADER = By.xpath("//h4[contains(.,'Print Workouts')]/ancestor::div[@class='w-box-header']");
    private static final By PRINT_WORKOUTS_BUTTON = By.id("saveButtonPrint");

    public PrintWorkoutsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Print workouts page has opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(PRINT_WORKOUTS_HEADER));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open print workouts page", PRINT_WORKOUTS_PAGE_BUTTON);
        driver.findElement(PRINT_WORKOUTS_PAGE_BUTTON).click();
    }

    public void clickPrintWorkoutsButton() {
        log.info("Click {} in order to print workouts", PRINT_WORKOUTS_BUTTON);
        driver.findElement(PRINT_WORKOUTS_BUTTON).click();
    }

}