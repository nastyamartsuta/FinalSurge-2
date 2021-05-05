package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

@Log4j2
public class LoginSteps extends AbstractStep {

    private static final By EMAIL_INPUT = By.id("login_name");
    private static final By PASSWORD_INPUT = By.id("login_password");
    private static final By LOGIN_BUTTON = By.className("btn");
    private static final String VALID_EMAIL = System.getProperty("email_account");
    private static final String VALID_PASSWORD = System.getProperty("password_account");

    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public LoginSteps openLoginPage() {
        log.info("open Login Page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setExplicitlyWaitTimeout(10);
        loginPage.openPage();
        validateComponentIsLoaded(loginPage);
        return this;

    }

    @Step
    public void authentication() {
        log.info("send text {} to text field {}", EMAIL_INPUT, "email");
        driver.findElement(EMAIL_INPUT).sendKeys(VALID_EMAIL);
        log.info("send text {} to text field {}", PASSWORD_INPUT, "password");
        driver.findElement(PASSWORD_INPUT).sendKeys(VALID_PASSWORD);
        log.info("click {}", LOGIN_BUTTON);
        driver.findElement(LOGIN_BUTTON).click();
        log.info("open Home Page");
        HomePage homePage = new HomePage(driver);
        validateComponentIsLoaded(homePage);
    }
}
