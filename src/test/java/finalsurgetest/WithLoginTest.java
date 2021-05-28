package finalsurgetest;

import org.testng.annotations.BeforeMethod;

public class WithLoginTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
        loginSteps
                .openLoginPage()
                .authenticationWithValidData();
    }
}
