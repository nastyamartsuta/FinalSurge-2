package finalsurgetest;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    @Description(value = "Login test")
    public void loginTest() {
        loginSteps
                .openLoginPage()
                .authentication();
    }
}
