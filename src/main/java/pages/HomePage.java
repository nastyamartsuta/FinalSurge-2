package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class HomePage extends BasePage {

    private static final String BASE_URN = "https://log.finalsurge.com/UserProfile.cshtml/";
    private static final By USER_PROFILE = By.xpath("//h4[contains(.,'User Profile')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(USER_PROFILE));
        log.info("Checking that the Home page was opened");
    }

    @Override
    public void openPage() {
        driver.get(BASE_URN);
        log.info("open {}", BASE_URN);
    }
}
