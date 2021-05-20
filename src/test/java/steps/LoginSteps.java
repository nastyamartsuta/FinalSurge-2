package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

@Log4j2
public class LoginSteps extends AbstractStep {

    LoginPage loginPage = new LoginPage(driver);

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
    public void authentication() {
        loginPage.sendValidData();
        HomePage homePage = new HomePage(driver);
        validateComponentIsLoaded(homePage);
    }
}
