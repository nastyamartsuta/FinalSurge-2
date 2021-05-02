package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage{

    private static final String BASE_URN = "https://log.finalsurge.com/UserProfile.cshtml/";
    private static final By LOGIN_BUTTON = By.className("btn");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        log.info("Checking that the Open page has opened");
    }

    @Override
    public void openPage() {
        driver.get(BASE_URN);
        log.info("open {}", BASE_URN);
    }

}
