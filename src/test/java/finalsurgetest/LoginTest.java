package finalsurgetest;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static pages.LoginPage.*;

public class LoginTest extends BaseTest {

    @Test
    @Description(value = "Login test with valid data")
    public void loginWithValidDataTest() {
        loginSteps
                .openLoginPage()
                .authenticationWithValidData();
    }

    @Test
    @Description(value = "Login test with invalid data ")
    public void loginWithInvalidDataTest() {
        loginSteps
                .openLoginPage()
                .authenticationWithInvalidData(INVALID_EMAIL, INVALID_PASSWORD);
    }

    @Test
    @Description(value = "Login test with invalid password ")
    public void loginWithInvalidPasswordTest() {
        loginSteps
                .openLoginPage()
                .authenticationWithInvalidData(VALID_EMAIL, INVALID_PASSWORD);
    }

    @Test
    @Description(value = "Login test with invalid email ")
    public void loginWithInvalidEmailTest() {
        loginSteps
                .openLoginPage()
                .authenticationWithInvalidData(INVALID_EMAIL, VALID_PASSWORD);
    }

    @Test
    @Description(value = "Login test with empty password ")
    public void loginWithEmptyPasswordTest() {
        loginSteps
                .openLoginPage()
                .authenticationWithEmptyPassword();
    }

    @Test
    @Description(value = "Login test with empty email")
    public void loginWithEmptyEmailTest() {
        loginSteps
                .openLoginPage()
                .authenticationWithEmptyEmail();
    }

    @Test
    @Description(value = "Login test with empty data")
    public void loginWithEmptyDataTest() {
        loginSteps
                .openLoginPage()
                .authenticationWithEmptyData();
    }
}
