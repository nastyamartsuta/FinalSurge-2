package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class PrintPage extends BasePage {

    private static final By HEADER_PRINT_PAGE = By.id("printlink");

    public PrintPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Print page was opened and workout was printed");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_PRINT_PAGE));
    }

    @Override
    public void openPage() { }
}
