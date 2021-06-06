package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.PropertiesUtils.getSystemProperty;

@Log4j2
public class LoginPage extends BasePage {

    public static final String VALID_EMAIL = getSystemProperty("email_account");
    public static final String VALID_PASSWORD = getSystemProperty("password_account");
    public static final String INVALID_PASSWORD = "invalid_password";
    public static final String INVALID_EMAIL = "jb@gmail.com";
    public static final By ERROR_ALERT = By.xpath("//div[@class='alert alert-error']");
    public static final By ENTER_PASSWORD_ERROR_ALERT = By.xpath("//div[@class='formpad']//label[@for='login_password']");
    public static final By ENTER_EMAIL_ERROR_ALERT = By.xpath("//div[@class='formpad']//label[@for='login_name']");
    private static final String BASE_URN = "https://log.finalsurge.com/UserProfile.cshtml/";
    private static final By LOGIN_BUTTON = By.className("btn");
    private static final By EMAIL_INPUT = By.id("login_name");
    private static final By PASSWORD_INPUT = By.id("login_password");

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

    public void sendData(String email, String password) {
        log.info("Send text {} to text field {}", EMAIL_INPUT, "email");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        log.info("Send text {} to text field {}", PASSWORD_INPUT, "password");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("Click {}", LOGIN_BUTTON);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void alertOpen(By alert) {
        log.info("Checking that the alert was opened");
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(alert));
    }
}
