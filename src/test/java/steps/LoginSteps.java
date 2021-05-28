package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import static pages.LoginPage.*;

@Log4j2
public class LoginSteps extends AbstractStep {

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public LoginSteps openLoginPage() {
        loginPage.setExplicitlyWaitTimeout(10);
        loginPage.openPage();
        validateComponentIsLoaded(loginPage);
        return this;
    }

    @Step
    public void authenticationWithValidData() {
        loginPage.sendData(VALID_EMAIL, VALID_PASSWORD);
        validateComponentIsLoaded(homePage);
    }

    @Step
    public void authenticationWithInvalidData(String email, String password) {
        loginPage.sendData(email, password);
        loginPage.alertOpen(ERROR_ALERT);
        validateComponentIsLoaded(loginPage);
    }

    @Step
    public void authenticationWithEmptyData() {
        loginPage.sendData("", "");
        loginPage.alertOpen(ENTER_PASSWORD_ERROR_ALERT);
        loginPage.alertOpen(ENTER_EMAIL_ERROR_ALERT);
        validateComponentIsLoaded(loginPage);
    }

    @Step
    public void authenticationWithEmptyPassword() {
        loginPage.sendData(VALID_PASSWORD, "");
        loginPage.alertOpen(ENTER_PASSWORD_ERROR_ALERT);
        validateComponentIsLoaded(loginPage);
    }

    @Step
    public void authenticationWithEmptyEmail() {
        loginPage.sendData("", VALID_PASSWORD);
        loginPage.alertOpen(ENTER_EMAIL_ERROR_ALERT);
        validateComponentIsLoaded(loginPage);
    }
}
