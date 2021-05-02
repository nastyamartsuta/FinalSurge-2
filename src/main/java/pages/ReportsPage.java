package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ReportsPage extends BasePage{

    private static final By REPORTS_BUTTON = By.className("icsw16-graph");
    private static final By HEADER_REPORTS_PAGE = By.xpath("//h4[contains(.,'Report Filters')]/ancestor::div[@class='w-box-header']");
    private static final By HEADER_REPORTS = By.xpath("//h4[contains(.,'Athlete Workout Report')]/ancestor::div[@class='w-box-header']");
    private static final By VIEW_REPORTS_BUTTON = By.id("saveButton");

    public ReportsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Reports page has opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_REPORTS_PAGE));
    }

    @Override
    public void openPage() {
        log.info("Click {} in order to open reports page", REPORTS_BUTTON);
        driver.findElement(REPORTS_BUTTON).click();
    }

    public void viewReportButton() {
        log.info("Click {} in order to show the result", VIEW_REPORTS_BUTTON);
        driver.findElement(VIEW_REPORTS_BUTTON).click();
    }

    public boolean checkReportsOpened(){
        log.info("Checking that the Reports opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_REPORTS));
        return true;
    }
}
