package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage{

    private static final String BASE_URN = "https://log.finalsurge.com/UserProfile.cshtml/";
    private static final By LOGIN_BUTTON = By.className("btn");
    private static final By EMAIL_INPUT = By.id("login_name");
    private static final By PASSWORD_INPUT = By.id("login_password");
    private static final String VALID_EMAIL = System.getProperty("email_account");
    private static final String VALID_PASSWORD = System.getProperty("password_account");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        log.info("Checking that the Login page was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    @Override
    public void openPage() {
        log.info("Open Login Page {}", BASE_URN);
        driver.get(BASE_URN);
    }

    public void sendValidData() {
        log.info("Send text {} to text field {}", EMAIL_INPUT, "email");
        driver.findElement(EMAIL_INPUT).sendKeys(VALID_EMAIL);
        log.info("Send text {} to text field {}", PASSWORD_INPUT, "password");
        driver.findElement(PASSWORD_INPUT).sendKeys(VALID_PASSWORD);
        log.info("Click {}", LOGIN_BUTTON);
        driver.findElement(LOGIN_BUTTON).click();
    }

}
